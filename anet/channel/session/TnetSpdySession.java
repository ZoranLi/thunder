package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.Session.Status;
import anet.channel.SessionInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.EventType;
import anet.channel.entity.b;
import anet.channel.entity.c;
import anet.channel.entity.d;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.request.TnetCancelable;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.service.av;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;
import org.android.spdy.TnetStatusCode;

/* compiled from: Taobao */
public class TnetSpdySession extends Session implements SessionCb {
    private static final int MAX_ERROR_COUNT = 5;
    private static final long MAX_ERROR_INTERVAL = 60000;
    private static final String SSL_TIKET_KEY2 = "accs_ssl_key2_";
    private static final String TAG = "awcn.TnetSpdySession";
    private ConcurrentHashMap<String, List<Long>> accsHostErrors = new ConcurrentHashMap();
    protected IAuth auth = null;
    protected DataFrameCb dataFrameCb = null;
    protected IHeartbeat heartbeat = null;
    protected ISecurity iSecurity = null;
    protected SpdyAgent mAgent;
    protected String mAppkey = null;
    protected long mConnectedTime = 0;
    protected volatile boolean mHasUnrevPing = false;
    protected long mLastPingTime;
    protected SpdySession mSession;
    private int requestTimeoutCount = 0;
    protected int tnetPublicKey = -1;

    /* compiled from: Taobao */
    private class a extends a {
        final /* synthetic */ TnetSpdySession a;
        private Request b;
        private RequestCb c;
        private long d = 0;
        private long e = 0;
        private long f = 0;

        public a(TnetSpdySession tnetSpdySession, Request request, RequestCb requestCb) {
            this.a = tnetSpdySession;
            this.b = request;
            this.c = requestCb;
            this.d = System.currentTimeMillis();
        }

        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
            ALog.d(TnetSpdySession.TAG, "spdyDataChunkRecvCB", this.b.getSeq(), new Object[]{"len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z)});
            if (this.b.rs.firstDataTime == 0) {
                this.b.rs.firstDataTime = System.currentTimeMillis();
            }
            if (this.c != null) {
                spdySession = a.a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.c.onDataReceive(spdySession, z);
            }
            this.a.handleCallbacks(EventType.DATA_RECEIVE, 0);
        }

        public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, Object obj, SuperviseData superviseData) {
            ALog.d(TnetSpdySession.TAG, "spdyStreamCloseCallback", this.b.getSeq(), "streamId", Long.valueOf(j));
            this.e = System.currentTimeMillis();
            a(superviseData);
            spdySession = HttpConstant.SUCCESS;
            if (i != 0) {
                if (i != -2005) {
                    spdySession = new StringBuilder("statusCode=");
                    spdySession.append(i);
                    spdySession = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, spdySession.toString());
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, spdySession, this.b.rs, null));
                }
                ALog.e(TnetSpdySession.TAG, "spdyStreamCloseCallback error", this.b.getSeq(), "status code", Integer.valueOf(i));
            }
            if (this.c != null) {
                this.c.onFinish(i, spdySession, this.b.rs);
            }
            if (i == TnetStatusCode.EASY_REASON_SESSION_TIMEOUT && TnetSpdySession.access$504(this.a) >= 2) {
                spdySession = new ConnEvent();
                spdySession.isSuccess = false;
                StrategyCenter.getInstance().notifyConnEvent(this.a.mRealHost, this.a.mConnStrategy, spdySession);
                this.a.close(true);
            }
        }

        private void a(org.android.spdy.SuperviseData r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r7 = this;
            r0 = r7.e;	 Catch:{ Exception -> 0x00bb }
            r2 = 0;	 Catch:{ Exception -> 0x00bb }
            r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x00bb }
            if (r4 <= 0) goto L_0x00ba;	 Catch:{ Exception -> 0x00bb }
        L_0x0008:
            r0 = r7.d;	 Catch:{ Exception -> 0x00bb }
            r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x00bb }
            if (r4 > 0) goto L_0x0010;	 Catch:{ Exception -> 0x00bb }
        L_0x000e:
            goto L_0x00ba;	 Catch:{ Exception -> 0x00bb }
        L_0x0010:
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r4 = r7.f;	 Catch:{ Exception -> 0x00bb }
            r0.serverRT = r4;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r1 = r1.rs;	 Catch:{ Exception -> 0x00bb }
            r4 = r1.firstDataTime;	 Catch:{ Exception -> 0x00bb }
            r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x00bb }
            if (r1 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x00bb }
        L_0x0026:
            r1 = r7.e;	 Catch:{ Exception -> 0x00bb }
            r3 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r3 = r3.rs;	 Catch:{ Exception -> 0x00bb }
            r3 = r3.firstDataTime;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 - r3;	 Catch:{ Exception -> 0x00bb }
            r2 = r5;	 Catch:{ Exception -> 0x00bb }
        L_0x0031:
            r0.recDataTime = r2;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r7.e;	 Catch:{ Exception -> 0x00bb }
            r3 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r3 = r3.rs;	 Catch:{ Exception -> 0x00bb }
            r3 = r3.start;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 - r3;	 Catch:{ Exception -> 0x00bb }
            r0.oneWayTime = r5;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r1 = r1.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r1.oneWayTime;	 Catch:{ Exception -> 0x00bb }
            r0.waitingTime = r1;	 Catch:{ Exception -> 0x00bb }
            if (r8 == 0) goto L_0x00b9;	 Catch:{ Exception -> 0x00bb }
        L_0x0051:
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r8.responseStart;	 Catch:{ Exception -> 0x00bb }
            r3 = r8.sendStart;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 - r3;	 Catch:{ Exception -> 0x00bb }
            r0.firstDataTime = r5;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r8.responseEnd;	 Catch:{ Exception -> 0x00bb }
            r3 = r8.responseStart;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 - r3;	 Catch:{ Exception -> 0x00bb }
            r0.recDataTime = r5;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r8.sendStart;	 Catch:{ Exception -> 0x00bb }
            r3 = r7.d;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 - r3;	 Catch:{ Exception -> 0x00bb }
            r0.sendBeforeTime = r5;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r8.sendEnd;	 Catch:{ Exception -> 0x00bb }
            r3 = r8.sendStart;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 - r3;	 Catch:{ Exception -> 0x00bb }
            r0.sendDataTime = r5;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r8.bodySize;	 Catch:{ Exception -> 0x00bb }
            r2 = r8.compressSize;	 Catch:{ Exception -> 0x00bb }
            r1 = r1 + r2;	 Catch:{ Exception -> 0x00bb }
            r1 = (long) r1;	 Catch:{ Exception -> 0x00bb }
            r0.sendDataSize = r1;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.b;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.rs;	 Catch:{ Exception -> 0x00bb }
            r1 = r8.recvBodySize;	 Catch:{ Exception -> 0x00bb }
            r2 = r8.recvCompressSize;	 Catch:{ Exception -> 0x00bb }
            r1 = r1 + r2;	 Catch:{ Exception -> 0x00bb }
            r1 = (long) r1;	 Catch:{ Exception -> 0x00bb }
            r0.recDataSize = r1;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.a;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.mSessionStat;	 Catch:{ Exception -> 0x00bb }
            r1 = r0.recvSizeCount;	 Catch:{ Exception -> 0x00bb }
            r3 = r8.recvBodySize;	 Catch:{ Exception -> 0x00bb }
            r4 = r8.recvCompressSize;	 Catch:{ Exception -> 0x00bb }
            r3 = r3 + r4;	 Catch:{ Exception -> 0x00bb }
            r3 = (long) r3;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 + r3;	 Catch:{ Exception -> 0x00bb }
            r0.recvSizeCount = r5;	 Catch:{ Exception -> 0x00bb }
            r0 = r7.a;	 Catch:{ Exception -> 0x00bb }
            r0 = r0.mSessionStat;	 Catch:{ Exception -> 0x00bb }
            r1 = r0.sendSizeCount;	 Catch:{ Exception -> 0x00bb }
            r3 = r8.bodySize;	 Catch:{ Exception -> 0x00bb }
            r8 = r8.compressSize;	 Catch:{ Exception -> 0x00bb }
            r3 = r3 + r8;	 Catch:{ Exception -> 0x00bb }
            r3 = (long) r3;	 Catch:{ Exception -> 0x00bb }
            r5 = r1 + r3;	 Catch:{ Exception -> 0x00bb }
            r0.sendSizeCount = r5;	 Catch:{ Exception -> 0x00bb }
        L_0x00b9:
            return;
        L_0x00ba:
            return;
        L_0x00bb:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.a.a(org.android.spdy.SuperviseData):void");
        }

        public void spdyOnStreamResponse(org.android.spdy.SpdySession r6, long r7, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r9, java.lang.Object r10) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r6 = 0;
            r7 = ":status";	 Catch:{ NumberFormatException -> 0x001c }
            r7 = r9.get(r7);	 Catch:{ NumberFormatException -> 0x001c }
            r7 = (java.util.List) r7;	 Catch:{ NumberFormatException -> 0x001c }
            if (r7 == 0) goto L_0x001c;	 Catch:{ NumberFormatException -> 0x001c }
        L_0x000b:
            r8 = r7.isEmpty();	 Catch:{ NumberFormatException -> 0x001c }
            if (r8 != 0) goto L_0x001c;	 Catch:{ NumberFormatException -> 0x001c }
        L_0x0011:
            r7 = r7.get(r6);	 Catch:{ NumberFormatException -> 0x001c }
            r7 = (java.lang.String) r7;	 Catch:{ NumberFormatException -> 0x001c }
            r7 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x001c }
            goto L_0x001d;
        L_0x001c:
            r7 = r6;
        L_0x001d:
            r8 = 1;
            if (r7 <= 0) goto L_0x002b;
        L_0x0020:
            r10 = r5.b;
            r10 = r10.rs;
            r10.ret = r8;
            r10 = r5.a;
            r10.requestTimeoutCount = r6;
        L_0x002b:
            r10 = "awcn.TnetSpdySession";
            r0 = "";
            r1 = r5.b;
            r1 = r1.getSeq();
            r2 = 2;
            r3 = new java.lang.Object[r2];
            r4 = "httpStatusCode";
            r3[r6] = r4;
            r4 = java.lang.Integer.valueOf(r7);
            r3[r8] = r4;
            anet.channel.util.ALog.i(r10, r0, r1, r3);
            r10 = "awcn.TnetSpdySession";
            r0 = "";
            r1 = r5.b;
            r1 = r1.getSeq();
            r2 = new java.lang.Object[r2];
            r3 = "response headers";
            r2[r6] = r3;
            r2[r8] = r9;
            anet.channel.util.ALog.i(r10, r0, r1, r2);
            r8 = r5.c;
            if (r8 == 0) goto L_0x0067;
        L_0x005e:
            r8 = r5.c;
            r10 = anet.channel.util.a.a(r9);
            r8.onResponseCode(r7, r10);
        L_0x0067:
            r8 = r5.a;
            r10 = anet.channel.entity.EventType.HEADER_RECEIVE;
            r0 = 0;
            r8.handleCallbacks(r10, r0);
            r8 = "s-rt";	 Catch:{ NumberFormatException -> 0x008b }
            r8 = r9.get(r8);	 Catch:{ NumberFormatException -> 0x008b }
            r8 = (java.util.List) r8;	 Catch:{ NumberFormatException -> 0x008b }
            if (r8 == 0) goto L_0x008b;	 Catch:{ NumberFormatException -> 0x008b }
        L_0x0079:
            r9 = r8.isEmpty();	 Catch:{ NumberFormatException -> 0x008b }
            if (r9 != 0) goto L_0x008b;	 Catch:{ NumberFormatException -> 0x008b }
        L_0x007f:
            r6 = r8.get(r6);	 Catch:{ NumberFormatException -> 0x008b }
            r6 = (java.lang.String) r6;	 Catch:{ NumberFormatException -> 0x008b }
            r8 = java.lang.Long.parseLong(r6);	 Catch:{ NumberFormatException -> 0x008b }
            r5.f = r8;	 Catch:{ NumberFormatException -> 0x008b }
        L_0x008b:
            r6 = r5.a;
            r8 = r5.b;
            r6.handleResponseCode(r8, r7);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.a.spdyOnStreamResponse(org.android.spdy.SpdySession, long, java.util.Map, java.lang.Object):void");
        }
    }

    public void bioPingRecvCallback(SpdySession spdySession, int i) {
    }

    static /* synthetic */ int access$504(TnetSpdySession tnetSpdySession) {
        int i = tnetSpdySession.requestTimeoutCount + 1;
        tnetSpdySession.requestTimeoutCount = i;
        return i;
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar, Config config, SessionInfo sessionInfo, int i) {
        super(context, aVar, aVar.c());
        this.mAppkey = config.getAppkey();
        this.iSecurity = config.getSecurity();
        initSpdyAgent();
        if (i >= 0) {
            this.tnetPublicKey = i;
        } else {
            this.tnetPublicKey = this.mConnType.getTnetPublicKey(this.iSecurity.isSecOff());
        }
        if (sessionInfo != null) {
            this.dataFrameCb = sessionInfo.dataFrameCb;
            this.auth = sessionInfo.auth;
            if (sessionInfo.isKeepAlive != null) {
                this.mSessionStat.isKL = 1;
                this.autoReCreate = true;
                this.heartbeat = sessionInfo.heartbeat;
                if (this.heartbeat == null) {
                    this.heartbeat = HeartbeatManager.getHeartbeatFactory().createHeartbeat(this);
                }
            }
        }
    }

    public Cancelable request(Request request, RequestCb requestCb) {
        TnetCancelable tnetCancelable;
        SpdyErrorException spdyErrorException;
        Exception exception;
        TnetSpdySession tnetSpdySession = this;
        Request request2 = request;
        RequestCb requestCb2 = requestCb;
        Cancelable cancelable = TnetCancelable.NULL;
        RequestStatistic requestStatistic = request2 != null ? request2.rs : new RequestStatistic(tnetSpdySession.mRealHost, null);
        requestStatistic.setConnType(tnetSpdySession.mConnType);
        requestStatistic.setIPAndPort(tnetSpdySession.mIp, tnetSpdySession.mPort);
        if (requestStatistic.start == 0) {
            requestStatistic.start = System.currentTimeMillis();
        }
        if (request2 != null) {
            if (requestCb2 != null) {
                try {
                    if (tnetSpdySession.mSession == null || !(tnetSpdySession.mStatus == Status.CONNECTED || tnetSpdySession.mStatus == Status.AUTH_SUCC)) {
                        requestCb2.onFinish(ErrorConstant.ERROR_SESSION_INVALID, "Session不可用", request2.rs);
                        return cancelable;
                    }
                    int i;
                    SpdyRequest spdyRequest;
                    Map headers;
                    int submitRequest;
                    SessionStatistic sessionStatistic;
                    request2.setUrlScheme(tnetSpdySession.mConnType.isSSL());
                    URL url = request.getUrl();
                    if (ALog.isPrintLog(2)) {
                        ALog.i(TAG, "", request.getSeq(), "request URL", url.toString());
                        ALog.i(TAG, "", request.getSeq(), "request Method", request.getMethod());
                        ALog.i(TAG, "", request.getSeq(), "request headers", request.getHeaders());
                    }
                    if (!TextUtils.isEmpty(tnetSpdySession.mProxyIp)) {
                        if (tnetSpdySession.mProxyPort > 0) {
                            i = 1;
                            spdyRequest = new SpdyRequest(url, url.getHost(), url.getPort(), tnetSpdySession.mProxyIp, tnetSpdySession.mProxyPort, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, request.getReadTimeout(), request.getConnectTimeout(), 0);
                            headers = request.getHeaders();
                            if (headers.containsKey(HttpConstant.HOST)) {
                                spdyRequest.addHeaders(headers);
                                spdyRequest.addHeader(":host", request.getHost());
                            } else {
                                headers = new HashMap(request.getHeaders());
                                headers.put(":host", headers.remove(HttpConstant.HOST));
                                spdyRequest.addHeaders(headers);
                            }
                            submitRequest = tnetSpdySession.mSession.submitRequest(spdyRequest, new SpdyDataProvider(request.getBodyBytes()), tnetSpdySession, new a(tnetSpdySession, request2, requestCb2));
                            if (ALog.isPrintLog(i)) {
                                ALog.d(TAG, "", request.getSeq(), "streamId", Integer.valueOf(submitRequest));
                            }
                            tnetCancelable = new TnetCancelable(tnetSpdySession.mSession, submitRequest, request.getSeq());
                            sessionStatistic = tnetSpdySession.mSessionStat;
                            sessionStatistic.requestCount++;
                            sessionStatistic = tnetSpdySession.mSessionStat;
                            sessionStatistic.stdRCount++;
                            tnetSpdySession.mLastPingTime = System.currentTimeMillis();
                            if (tnetSpdySession.heartbeat != null) {
                                tnetSpdySession.heartbeat.reSchedule();
                            }
                            cancelable = tnetCancelable;
                            return cancelable;
                        }
                    }
                    i = 1;
                    SpdyRequest spdyRequest2 = new SpdyRequest(url, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, request.getReadTimeout(), request.getConnectTimeout());
                    headers = request.getHeaders();
                    if (headers.containsKey(HttpConstant.HOST)) {
                        headers = new HashMap(request.getHeaders());
                        headers.put(":host", headers.remove(HttpConstant.HOST));
                        spdyRequest.addHeaders(headers);
                    } else {
                        spdyRequest.addHeaders(headers);
                        spdyRequest.addHeader(":host", request.getHost());
                    }
                    submitRequest = tnetSpdySession.mSession.submitRequest(spdyRequest, new SpdyDataProvider(request.getBodyBytes()), tnetSpdySession, new a(tnetSpdySession, request2, requestCb2));
                    if (ALog.isPrintLog(i)) {
                        ALog.d(TAG, "", request.getSeq(), "streamId", Integer.valueOf(submitRequest));
                    }
                    tnetCancelable = new TnetCancelable(tnetSpdySession.mSession, submitRequest, request.getSeq());
                    try {
                        sessionStatistic = tnetSpdySession.mSessionStat;
                        sessionStatistic.requestCount++;
                        sessionStatistic = tnetSpdySession.mSessionStat;
                        sessionStatistic.stdRCount++;
                        tnetSpdySession.mLastPingTime = System.currentTimeMillis();
                        if (tnetSpdySession.heartbeat != null) {
                            tnetSpdySession.heartbeat.reSchedule();
                        }
                        cancelable = tnetCancelable;
                    } catch (SpdyErrorException e) {
                        spdyErrorException = e;
                        cancelable = tnetCancelable;
                        if (spdyErrorException.SpdyErrorGetCode() == TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE || spdyErrorException.SpdyErrorGetCode() == TnetStatusCode.TNET_JNI_ERR_STATUS_ERR) {
                            ALog.e(TAG, "Send request on closed session!!!", tnetSpdySession.mSeq, new Object[0]);
                            notifyStatus(Status.DISCONNECTED, new c(EventType.DISCONNECTED, false, TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE, "Session is closed!"));
                        }
                        requestCb2.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, spdyErrorException.toString()), requestStatistic);
                        return cancelable;
                    } catch (Exception e2) {
                        exception = e2;
                        cancelable = tnetCancelable;
                        requestCb2.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_EXCEPTION, exception.toString()), requestStatistic);
                        return cancelable;
                    }
                    return cancelable;
                } catch (SpdyErrorException e3) {
                    spdyErrorException = e3;
                    ALog.e(TAG, "Send request on closed session!!!", tnetSpdySession.mSeq, new Object[0]);
                    notifyStatus(Status.DISCONNECTED, new c(EventType.DISCONNECTED, false, TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE, "Session is closed!"));
                    requestCb2.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, spdyErrorException.toString()), requestStatistic);
                    return cancelable;
                } catch (Exception e22) {
                    exception = e22;
                    requestCb2.onFinish(ErrorConstant.ERROR_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_EXCEPTION, exception.toString()), requestStatistic);
                    return cancelable;
                }
            }
        }
        if (requestCb2 != null) {
            requestCb2.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), requestStatistic);
        }
        return cancelable;
    }

    public void sendCustomFrame(int i, byte[] bArr, int i2) {
        try {
            if (this.dataFrameCb != null) {
                ALog.e(TAG, "sendCustomFrame", this.mSeq, Constants.KEY_DATA_ID, Integer.valueOf(i), "type", Integer.valueOf(i2));
                if (this.mStatus != Status.AUTH_SUCC || this.mSession == null) {
                    String str = this.mSeq;
                    Object[] objArr = new Object[1];
                    StringBuilder stringBuilder = new StringBuilder("sendCustomFrame con invalid mStatus:");
                    stringBuilder.append(this.mStatus);
                    objArr[0] = stringBuilder.toString();
                    ALog.e(TAG, "sendCustomFrame", str, objArr);
                    onDataFrameException(i, -301, true, "session invalid");
                } else if (bArr == null || bArr.length <= 16384) {
                    this.mSession.sendCustomControlFrame(i, i2, 0, bArr == null ? 0 : bArr.length, bArr);
                    bArr = this.mSessionStat;
                    bArr.requestCount++;
                    bArr = this.mSessionStat;
                    bArr.cfRCount++;
                    this.mLastPingTime = System.currentTimeMillis();
                    if (this.heartbeat != null) {
                        this.heartbeat.reSchedule();
                    }
                } else {
                    onDataFrameException(i, -303, false, 0);
                }
            }
        } catch (byte[] bArr2) {
            ALog.e(TAG, "sendCustomFrame error", this.mSeq, bArr2, new Object[0]);
            StringBuilder stringBuilder2 = new StringBuilder("SpdyErrorException: ");
            stringBuilder2.append(bArr2.toString());
            onDataFrameException(i, ErrorConstant.ERROR_TNET_EXCEPTION, true, stringBuilder2.toString());
        } catch (byte[] bArr22) {
            ALog.e(TAG, "sendCustomFrame error", this.mSeq, bArr22, new Object[0]);
            onDataFrameException(i, ErrorConstant.ERROR_EXCEPTION, true, bArr22.toString());
        }
    }

    private void onDataFrameException(int i, int i2, boolean z, String str) {
        if (this.dataFrameCb != null) {
            this.dataFrameCb.onException(i, i2, z, str);
        }
    }

    public void connect() {
        if (!(this.mStatus == Status.CONNECTING || this.mStatus == Status.CONNECTED)) {
            if (this.mStatus != Status.AUTH_SUCC) {
                try {
                    if (this.mAgent != null) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        String str = this.mSeq;
                        r5 = new Object[12];
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.mIp);
                        stringBuilder.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        stringBuilder.append(this.mPort);
                        r5[3] = stringBuilder.toString();
                        r5[4] = INoCaptchaComponent.sessionId;
                        r5[5] = valueOf;
                        r5[6] = "SpdyProtocol,";
                        r5[7] = this.mConnType;
                        r5[8] = "proxyIp,";
                        r5[9] = this.mProxyIp;
                        r5[10] = "proxyPort,";
                        r5[11] = Integer.valueOf(this.mProxyPort);
                        ALog.e(TAG, "[connect]", str, r5);
                        String str2 = this.mIp;
                        int i = this.mPort;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(this.mHost);
                        stringBuilder2.append("_");
                        stringBuilder2.append(this.mAppkey);
                        org.android.spdy.SessionInfo sessionInfo = new org.android.spdy.SessionInfo(str2, i, stringBuilder2.toString(), this.mProxyIp, this.mProxyPort, valueOf, this, this.mConnType.getTnetConType());
                        sessionInfo.setConnectionTimeoutMs((int) (((float) this.mConnTimeout) * Utils.getNetworkTimeFactor()));
                        sessionInfo.setPubKeySeqNum(this.tnetPublicKey);
                        this.mSession = this.mAgent.createSession(sessionInfo);
                        if (this.mSession.getRefCount() > 1) {
                            ALog.e(TAG, "get session ref count > 1!!!", this.mSeq, new Object[0]);
                            notifyStatus(Status.CONNECTED, new b(EventType.CONNECTED));
                            auth();
                            return;
                        }
                        notifyStatus(Status.CONNECTING, null);
                        this.mLastPingTime = System.currentTimeMillis();
                        SessionStatistic sessionStatistic = this.mSessionStat;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(TextUtils.isEmpty(this.mProxyIp) ^ true);
                        sessionStatistic.isProxy = stringBuilder2.toString();
                        this.mSessionStat.isTunnel = av.b;
                        this.mSessionStat.isBackground = GlobalAppRuntimeInfo.isAppBackground();
                        this.mConnectedTime = 0;
                    }
                } catch (Throwable th) {
                    notifyStatus(Status.CONNETFAIL, null);
                    ALog.e(TAG, "connect exception ", this.mSeq, th, new Object[0]);
                }
            }
        }
    }

    public void close() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = "awcn.TnetSpdySession";
        r1 = "force close!";
        r2 = r6.mSeq;
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = "session";
        r5 = 0;
        r3[r5] = r4;
        r4 = 1;
        r3[r4] = r6;
        anet.channel.util.ALog.e(r0, r1, r2, r3);
        r0 = anet.channel.Session.Status.DISCONNECTING;
        r1 = 0;
        r6.notifyStatus(r0, r1);
        r0 = r6.heartbeat;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r6.heartbeat;
        r0.stop();
        r6.heartbeat = r1;
    L_0x0025:
        r0 = r6.mSession;	 Catch:{ Exception -> 0x002f }
        if (r0 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x0029:
        r0 = r6.mSession;	 Catch:{ Exception -> 0x002f }
        r0.closeSession();	 Catch:{ Exception -> 0x002f }
    L_0x002e:
        return;
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.TnetSpdySession.close():void");
    }

    protected void onDisconnect() {
        this.mHasUnrevPing = false;
    }

    protected Runnable getRecvTimeOutRunnable() {
        return new h(this);
    }

    public void ping(boolean z) {
        if (ALog.isPrintLog(1)) {
            ALog.d(TAG, "ping", this.mSeq, "host", this.mHost, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.mSession == null) {
                    if (this.mSessionStat) {
                        this.mSessionStat.closeReason = "session null";
                    }
                    z = TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.mHost);
                    stringBuilder.append(" session null");
                    ALog.e(z, stringBuilder.toString(), this.mSeq, new Object[0]);
                    close();
                } else if (this.mStatus == Status.CONNECTED || this.mStatus == Status.AUTH_SUCC) {
                    handleCallbacks(EventType.PING_SEND, null);
                    this.mHasUnrevPing = true;
                    SessionStatistic sessionStatistic = this.mSessionStat;
                    sessionStatistic.ppkgCount++;
                    this.mSession.submitPing();
                    if (ALog.isPrintLog(1)) {
                        String str = TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(this.mHost);
                        stringBuilder2.append(" submit ping ms:");
                        stringBuilder2.append(System.currentTimeMillis() - this.mLastPingTime);
                        stringBuilder2.append(" force:");
                        stringBuilder2.append(z);
                        ALog.d(str, stringBuilder2.toString(), this.mSeq, new Object[0]);
                    }
                    setPingTimeout();
                    this.mLastPingTime = System.currentTimeMillis();
                    if (this.heartbeat) {
                        this.heartbeat.reSchedule();
                    }
                }
            } catch (boolean z2) {
                if (z2.SpdyErrorGetCode() == TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE || z2.SpdyErrorGetCode() == TnetStatusCode.TNET_JNI_ERR_STATUS_ERR) {
                    ALog.e(TAG, "Send request on closed session!!!", this.mSeq, new Object[0]);
                    notifyStatus(Status.DISCONNECTED, new c(EventType.DISCONNECTED, false, TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE, "Session is closed!"));
                }
                ALog.e(TAG, "ping", this.mSeq, z2, new Object[0]);
            } catch (boolean z22) {
                ALog.e(TAG, "ping", this.mSeq, z22, new Object[0]);
            }
        }
    }

    protected void auth() {
        if (this.auth != null) {
            this.auth.auth(this, new i(this));
            return;
        }
        notifyStatus(Status.AUTH_SUCC, null);
        this.mSessionStat.ret = 1;
        if (this.heartbeat != null) {
            this.heartbeat.start();
        }
    }

    public boolean isAvailable() {
        return this.mStatus == Status.AUTH_SUCC;
    }

    private void initSpdyAgent() {
        try {
            SpdyAgent.enableDebug = false;
            this.mAgent = SpdyAgent.getInstance(this.mContext, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (!(this.iSecurity == null || this.iSecurity.isSecOff())) {
                this.mAgent.setAccsSslCallback(new j(this));
            }
        } catch (Throwable e) {
            ALog.e(TAG, "Init failed.", null, e, new Object[0]);
        }
    }

    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spdySession = new b(EventType.CONNECTED);
        spdySession.a = (long) superviseConnectInfo.connectTime;
        spdySession.b = (long) superviseConnectInfo.handshakeTime;
        this.mSessionStat.connectionTime = (long) superviseConnectInfo.connectTime;
        this.mSessionStat.sslTime = (long) superviseConnectInfo.handshakeTime;
        this.mSessionStat.sslCalTime = (long) superviseConnectInfo.doHandshakeTime;
        this.mSessionStat.netType = NetworkStatusHelper.b();
        this.mConnectedTime = System.currentTimeMillis();
        notifyStatus(Status.CONNECTED, spdySession);
        auth();
        ALog.e(TAG, "spdySessionConnectCB connect", this.mSeq, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime:", Integer.valueOf(superviseConnectInfo.handshakeTime));
    }

    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        if (ALog.isPrintLog(2) != null) {
            ALog.i(TAG, "ping receive", this.mSeq, HttpConstant.HOST, this.mHost, AgooConstants.MESSAGE_ID, Long.valueOf(j));
        }
        if (j >= 0) {
            this.mHasUnrevPing = false;
            handleCallbacks(EventType.PIND_RECEIVE, 0);
        }
    }

    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i, int i2, int i3, int i4, byte[] bArr) {
        ALog.e(TAG, "[spdyCustomControlFrameRecvCallback]", this.mSeq, "len", Integer.valueOf(i4), "frameCb", this.dataFrameCb);
        if (ALog.isPrintLog(1) != null) {
            spdySession = "";
            if (i4 < 512) {
                i3 = spdySession;
                for (byte b : bArr) {
                    i4 = new StringBuilder();
                    i4.append(i3);
                    i4.append(Integer.toHexString(255 & b));
                    i4.append(" ");
                    i3 = i4.toString();
                }
                ALog.e(TAG, null, this.mSeq, "str", i3);
            }
        }
        if (this.dataFrameCb != null) {
            this.dataFrameCb.onDataReceive(this, bArr, i, i2);
        } else {
            ALog.e(TAG, "AccsFrameCb is null", this.mSeq, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_ACCS_CUSTOM_FRAME_CB_NULL, null, "rt"));
        }
        spdySession = this.mSessionStat;
        spdySession.inceptCount++;
    }

    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (SpdySession spdySession2) {
                ALog.e(TAG, "[spdySessionFailedError]session clean up failed!", null, spdySession2, new Object[0]);
            }
        }
        notifyStatus(Status.CONNETFAIL, new d(EventType.CONNECT_FAIL, i, "tnet connect fail"));
        ALog.e(TAG, null, this.mSeq, " errorId:", Integer.valueOf(i));
        this.mSessionStat.errorCode = (long) i;
        this.mSessionStat.ret = 0;
        this.mSessionStat.netType = NetworkStatusHelper.b();
        AppMonitor.getInstance().commitStat(this.mSessionStat);
        AppMonitor.getInstance().commitAlarm(this.mSessionStat.getAlarmObject());
    }

    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        ALog.e(TAG, "spdySessionCloseCallback", this.mSeq, " errorCode:", Integer.valueOf(i));
        if (this.heartbeat != null) {
            this.heartbeat.stop();
            this.heartbeat = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (SpdySession spdySession2) {
                ALog.e(TAG, "[spdySessionCloseCallback]session clean up failed!", null, spdySession2, new Object[0]);
            }
        }
        if (TextUtils.isEmpty(this.mSessionStat.closeReason) != null) {
            spdySession2 = new StringBuilder("tnet close error:");
            spdySession2.append(i);
        } else {
            spdySession2 = new StringBuilder();
            spdySession2.append(this.mSessionStat.closeReason);
            spdySession2.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            spdySession2.append(this.mSessionStat.errorCode);
        }
        notifyStatus(Status.DISCONNECTED, new c(EventType.DISCONNECTED, false, i, spdySession2.toString()));
        if (superviseConnectInfo != null) {
            this.mSessionStat.requestCount = (long) superviseConnectInfo.reused_counter;
            this.mSessionStat.liveTime = (long) superviseConnectInfo.keepalive_period_second;
        }
        if (this.mSessionStat.errorCode == 0) {
            this.mSessionStat.errorCode = (long) i;
        }
        this.mSessionStat.lastPingInterval = (int) (System.currentTimeMillis() - this.mLastPingTime);
        AppMonitor.getInstance().commitStat(this.mSessionStat);
        AppMonitor.getInstance().commitAlarm(this.mSessionStat.getAlarmObject());
    }

    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i, int i2) {
        ALog.e(TAG, "spdyCustomControlFrameFailCallback", this.mSeq, Constants.KEY_DATA_ID, Integer.valueOf(i));
        onDataFrameException(i, i2, true, "tnet error");
    }

    public byte[] getSSLMeta(SpdySession spdySession) {
        spdySession = spdySession.getDomain();
        if (TextUtils.isEmpty(spdySession)) {
            ALog.i(TAG, "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.iSecurity;
            Context context = this.mContext;
            StringBuilder stringBuilder = new StringBuilder(SSL_TIKET_KEY2);
            stringBuilder.append(spdySession);
            spdySession = iSecurity.getBytes(context, stringBuilder.toString());
        } catch (SpdySession spdySession2) {
            ALog.e(TAG, "getSSLMeta", null, spdySession2, new Object[0]);
            spdySession2 = null;
        }
        return spdySession2;
    }

    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        spdySession = spdySession.getDomain();
        int i = -1;
        if (TextUtils.isEmpty(spdySession)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.iSecurity;
            Context context = this.mContext;
            StringBuilder stringBuilder = new StringBuilder(SSL_TIKET_KEY2);
            stringBuilder.append(spdySession);
            if (iSecurity.saveBytes(context, stringBuilder.toString(), bArr) != null) {
                i = 0;
            }
        } catch (SpdySession spdySession2) {
            ALog.e(TAG, "putSSLMeta", null, spdySession2, new Object[0]);
        }
        return i;
    }

    private void handleResponseCode(Request request, int i) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            request = request.getHost();
            if (ALog.isPrintLog(1)) {
                ALog.d(TAG, "FailOverHandler hook onResponseCode", null, "host", request, "code", Integer.valueOf(i));
            }
            if (i >= 500 && i < 600) {
                i = (List) this.accsHostErrors.get(request);
                if (i == null) {
                    i = new LinkedList();
                    List list = (List) this.accsHostErrors.putIfAbsent(request, i);
                    if (list != null) {
                        i = list;
                    }
                }
                synchronized (i) {
                    if (i.size() < 5) {
                        i.add(Long.valueOf(System.currentTimeMillis()));
                    } else {
                        long longValue = ((Long) i.remove(0)).longValue();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - longValue <= MAX_ERROR_INTERVAL) {
                            StrategyCenter.getInstance().forceRefreshStrategy(request);
                            i.clear();
                        } else {
                            i.add(Long.valueOf(currentTimeMillis));
                        }
                    }
                }
            }
        }
    }
}
