package com.taobao.tao.remotebusiness;

import android.content.Context;
import com.taobao.tao.remotebusiness.listener.c;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.j;
import mtopsdk.mtop.b.b;
import mtopsdk.mtop.common.a;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;

public class MtopBusiness extends b {
    public static final int MAX_RETRY_TIMES = 3;
    private static final String TAG = "mtop.rb-RemoteBusiness";
    private static AtomicInteger seqGen = new AtomicInteger(0);
    private a apiID;
    public String authParam = null;
    public Class clazz;
    public boolean isCached = false;
    private boolean isCanceled = false;
    private boolean isErrorNotifyAfterCache = false;
    public k listener;
    private MtopResponse mtopResponse = null;
    public long onBgFinishTime = 0;
    public long reqStartTime = 0;
    protected int requestType = 0;
    protected int retryTime = 0;
    public long sendStartTime = 0;
    private final String seqNo = genSeqNo();
    public boolean showAuthUI = true;
    private boolean showLoginUI = true;
    private CountDownLatch syncRequestLatch = null;

    protected MtopBusiness(MtopRequest mtopRequest, String str) {
        super(mtopRequest, str);
    }

    protected MtopBusiness(mtopsdk.mtop.domain.b bVar, String str) {
        super(bVar, str);
    }

    public static MtopBusiness build(MtopRequest mtopRequest) {
        return new MtopBusiness(mtopRequest, null);
    }

    public static MtopBusiness build(MtopRequest mtopRequest, String str) {
        return new MtopBusiness(mtopRequest, str);
    }

    public static MtopBusiness build(mtopsdk.mtop.domain.b bVar) {
        return new MtopBusiness(bVar, null);
    }

    public static MtopBusiness build(mtopsdk.mtop.domain.b bVar, String str) {
        return new MtopBusiness(bVar, str);
    }

    public static void init(Context context, String str) {
        mtopsdk.mtop.b.a.a(context, str);
    }

    private void onErrorCallback(mtopsdk.mtop.domain.MtopResponse r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.listener;
        r0 = (com.taobao.tao.remotebusiness.IRemoteBaseListener) r0;
        if (r5 == 0) goto L_0x0010;
    L_0x0006:
        r1 = r3.requestType;	 Catch:{ Throwable -> 0x001a }
        r2 = r3.getReqContext();	 Catch:{ Throwable -> 0x001a }
        r0.onSystemError(r1, r4, r2);	 Catch:{ Throwable -> 0x001a }
        goto L_0x0021;	 Catch:{ Throwable -> 0x001a }
    L_0x0010:
        r1 = r3.requestType;	 Catch:{ Throwable -> 0x001a }
        r2 = r3.getReqContext();	 Catch:{ Throwable -> 0x001a }
        r0.onError(r1, r4, r2);	 Catch:{ Throwable -> 0x001a }
        goto L_0x0021;
    L_0x001a:
        r4 = r3.seqNo;
        r0 = "listener onError callback error";
        mtopsdk.common.util.j.f(r4, r0);
    L_0x0021:
        r4 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r4 = mtopsdk.common.util.j.a(r4);
        if (r4 == 0) goto L_0x0043;
    L_0x0029:
        r4 = r3.seqNo;
        r0 = new java.lang.StringBuilder;
        r1 = "listener onError callback, ";
        r0.<init>(r1);
        if (r5 == 0) goto L_0x0037;
    L_0x0034:
        r5 = "sys error";
        goto L_0x0039;
    L_0x0037:
        r5 = "biz error";
    L_0x0039:
        r0.append(r5);
        r5 = r0.toString();
        mtopsdk.common.util.j.b(r4, r5);
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.MtopBusiness.onErrorCallback(mtopsdk.mtop.domain.MtopResponse, boolean):void");
    }

    private void resetMtopListener() {
        if (!this.isCanceled && this.listener != null) {
            super.addListener(c.a(this, this.listener));
        }
    }

    public MtopBusiness addListener(k kVar) {
        return registeListener(kVar);
    }

    public a asyncRequest() {
        startRequest();
        return this.apiID;
    }

    public void cancelRequest() {
        cancelRequest(true);
    }

    public void doFinish(mtopsdk.mtop.domain.MtopResponse r5, mtopsdk.mtop.domain.a r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.syncRequestLatch;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r4.mtopResponse = r5;
        r0 = r4.syncRequestLatch;
        r0.countDown();
    L_0x000b:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x004e;
    L_0x0013:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "doFinish api=[";
        r0.append(r1);
        r1 = r4.request;
        r1 = r1.getApiName();
        r0.append(r1);
        r1 = "]";
        r0.append(r1);
        if (r5 == 0) goto L_0x0045;
    L_0x002d:
        r1 = " retCode=";
        r0.append(r1);
        r1 = r5.getRetCode();
        r0.append(r1);
        r1 = " retMsg=";
        r0.append(r1);
        r1 = r5.getRetCode();
        r0.append(r1);
    L_0x0045:
        r1 = r4.seqNo;
        r0 = r0.toString();
        mtopsdk.common.util.j.b(r1, r0);
    L_0x004e:
        r0 = r4.isCanceled;
        if (r0 != 0) goto L_0x00f6;
    L_0x0052:
        r0 = r4.listener;
        r0 = r0 instanceof com.taobao.tao.remotebusiness.IRemoteBaseListener;
        if (r0 != 0) goto L_0x005a;
    L_0x0058:
        goto L_0x00f6;
    L_0x005a:
        r0 = r4.listener;
        r0 = (com.taobao.tao.remotebusiness.IRemoteBaseListener) r0;
        r1 = 0;
        if (r5 != 0) goto L_0x006c;
    L_0x0061:
        r6 = r4.seqNo;
        r0 = "response is null.";
        mtopsdk.common.util.j.b(r6, r0);
        r4.onErrorCallback(r5, r1);
        return;
    L_0x006c:
        if (r5 == 0) goto L_0x008d;
    L_0x006e:
        r2 = r5.isApiSuccess();
        if (r2 == 0) goto L_0x008d;
    L_0x0074:
        r1 = r4.requestType;	 Catch:{ Throwable -> 0x007e }
        r2 = r4.getReqContext();	 Catch:{ Throwable -> 0x007e }
        r0.onSuccess(r1, r5, r6, r2);	 Catch:{ Throwable -> 0x007e }
        goto L_0x0085;
    L_0x007e:
        r5 = r4.seqNo;
        r6 = "listener onSuccess callback error";
        mtopsdk.common.util.j.f(r5, r6);
    L_0x0085:
        r5 = r4.seqNo;
        r6 = "listener onSuccess callback.";
        mtopsdk.common.util.j.b(r5, r6);
        return;
    L_0x008d:
        r6 = r4.isCached;
        if (r6 == 0) goto L_0x009d;
    L_0x0091:
        r6 = r4.isErrorNotifyAfterCache;
        if (r6 != 0) goto L_0x009d;
    L_0x0095:
        r5 = r4.seqNo;
        r6 = "listenr onCached callback,doNothing in doFinish()";
        mtopsdk.common.util.j.a(r5, r6);
        return;
    L_0x009d:
        r6 = r5.isSessionInvalid();
        r0 = 1;
        if (r6 == 0) goto L_0x00c3;
    L_0x00a4:
        r6 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r6 = mtopsdk.common.util.j.a(r6);
        if (r6 == 0) goto L_0x00bf;
    L_0x00ac:
        r6 = r4.seqNo;
        r2 = "尝试登录后仍session失效，或用户取消登录。";
        r3 = 0;
        r1 = com.taobao.tao.remotebusiness.listener.c.a(r2, r4, r1, r3);
        mtopsdk.common.util.j.b(r6, r1);
        r6 = r4.seqNo;
        r1 = "response.isSessionInvalid().";
        mtopsdk.common.util.j.b(r6, r1);
    L_0x00bf:
        r4.onErrorCallback(r5, r0);
        return;
    L_0x00c3:
        r6 = r5.isMtopServerError();
        if (r6 != 0) goto L_0x00f2;
    L_0x00c9:
        r6 = r5.isMtopSdkError();
        if (r6 != 0) goto L_0x00f2;
    L_0x00cf:
        r6 = r5.isNetworkError();
        if (r6 != 0) goto L_0x00f2;
    L_0x00d5:
        r6 = r5.isSystemError();
        if (r6 != 0) goto L_0x00f2;
    L_0x00db:
        r6 = r5.isExpiredRequest();
        if (r6 != 0) goto L_0x00f2;
    L_0x00e1:
        r6 = r5.is41XResult();
        if (r6 != 0) goto L_0x00f2;
    L_0x00e7:
        r6 = r5.isApiLockedResult();
        if (r6 == 0) goto L_0x00ee;
    L_0x00ed:
        goto L_0x00f2;
    L_0x00ee:
        r4.onErrorCallback(r5, r1);
        return;
    L_0x00f2:
        r4.onErrorCallback(r5, r0);
        return;
    L_0x00f6:
        r5 = r4.seqNo;
        r6 = "doFinish no callback.";
        mtopsdk.common.util.j.a(r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.MtopBusiness.doFinish(mtopsdk.mtop.domain.MtopResponse, mtopsdk.mtop.domain.a):void");
    }

    public int getRequestType() {
        return this.requestType;
    }

    public int getRetryTime() {
        return this.retryTime;
    }

    public String getSeqNo() {
        return this.seqNo;
    }

    public boolean isNeedAuth() {
        return this.authParam != null;
    }

    public boolean isShowLoginUI() {
        return this.showLoginUI;
    }

    public boolean isTaskCanceled() {
        return this.isCanceled;
    }

    public MtopBusiness registeListener(k kVar) {
        this.listener = kVar;
        return this;
    }

    void retryRequest() {
        if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
            j.b(this.seqNo, c.a("retryRequest.", this, false, null));
        }
        if (this.retryTime >= 3) {
            this.retryTime = 0;
            doFinish(null, null);
            return;
        }
        cancelRequest(false);
        startRequest(this.requestType, this.clazz);
        this.retryTime++;
    }

    public MtopBusiness setBizId(int i) {
        return (MtopBusiness) super.setBizId(i);
    }

    public MtopBusiness setErrorNotifyAfterCache(boolean z) {
        this.isErrorNotifyAfterCache = z;
        return this;
    }

    public MtopBusiness setNeedAuth(String str, boolean z) {
        if (j.a(TBSdkLog$LogEnable.DebugEnable)) {
            StringBuilder stringBuilder = new StringBuilder("setNeedAuth. authParam");
            stringBuilder.append(str);
            j.a(stringBuilder.toString());
        }
        this.authParam = str;
        this.showAuthUI = z;
        return this;
    }

    public MtopBusiness showLoginUI(boolean z) {
        this.showLoginUI = z;
        return this;
    }

    public void startRequest() {
        startRequest(0, null);
    }

    public void startRequest(int i, Class cls) {
        if (this.request == null) {
            j.e(this.seqNo, "request is null!!!");
            return;
        }
        if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
            String str = this.seqNo;
            StringBuilder stringBuilder = new StringBuilder("start request api=[");
            stringBuilder.append(this.request.getApiName());
            stringBuilder.append("]");
            j.b(str, stringBuilder.toString());
        }
        this.reqStartTime = System.currentTimeMillis();
        this.isCanceled = false;
        this.isCached = false;
        this.clazz = cls;
        this.requestType = i;
        resetMtopListener();
        mtopCommitStatData(false);
        doQuery();
    }

    public void startRequest(Class cls) {
        startRequest(0, cls);
    }

    public mtopsdk.mtop.domain.MtopResponse syncRequest() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.seqNo;
        r1 = "syncRequest";
        mtopsdk.common.util.j.b(r0, r1);
        r0 = new java.util.concurrent.CountDownLatch;
        r1 = 1;
        r0.<init>(r1);
        r5.syncRequestLatch = r0;
        r0 = r5.listener;
        if (r0 != 0) goto L_0x001a;
    L_0x0013:
        r0 = new com.taobao.tao.remotebusiness.MtopBusiness$1;
        r0.<init>();
        r5.listener = r0;
    L_0x001a:
        r5.startRequest();
        r0 = r5.syncRequestLatch;	 Catch:{ InterruptedException -> 0x004d }
        r1 = 120; // 0x78 float:1.68E-43 double:5.93E-322;	 Catch:{ InterruptedException -> 0x004d }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x004d }
        r0 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x004d }
        if (r0 != 0) goto L_0x0075;	 Catch:{ InterruptedException -> 0x004d }
    L_0x0029:
        r0 = r5.seqNo;	 Catch:{ InterruptedException -> 0x004d }
        r1 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x004d }
        r2 = "syncRequest timeout . apiKey=";	 Catch:{ InterruptedException -> 0x004d }
        r1.<init>(r2);	 Catch:{ InterruptedException -> 0x004d }
        r2 = r5.request;	 Catch:{ InterruptedException -> 0x004d }
        r1.append(r2);	 Catch:{ InterruptedException -> 0x004d }
        r1 = r1.toString();	 Catch:{ InterruptedException -> 0x004d }
        if (r1 == 0) goto L_0x0044;	 Catch:{ InterruptedException -> 0x004d }
    L_0x003d:
        r1 = r5.request;	 Catch:{ InterruptedException -> 0x004d }
        r1 = r1.getKey();	 Catch:{ InterruptedException -> 0x004d }
        goto L_0x0046;	 Catch:{ InterruptedException -> 0x004d }
    L_0x0044:
        r1 = "";	 Catch:{ InterruptedException -> 0x004d }
    L_0x0046:
        mtopsdk.common.util.j.c(r0, r1);	 Catch:{ InterruptedException -> 0x004d }
        r5.cancelRequest();	 Catch:{ InterruptedException -> 0x004d }
        goto L_0x0075;
    L_0x004d:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.ErrorEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x0075;
    L_0x0055:
        r0 = r5.seqNo;
        r1 = new java.lang.StringBuilder;
        r2 = "SyncRequest InterruptedException. apiKey=";
        r1.<init>(r2);
        r2 = r5.request;
        r1.append(r2);
        r1 = r1.toString();
        if (r1 == 0) goto L_0x0070;
    L_0x0069:
        r1 = r5.request;
        r1 = r1.getKey();
        goto L_0x0072;
    L_0x0070:
        r1 = "";
    L_0x0072:
        mtopsdk.common.util.j.e(r0, r1);
    L_0x0075:
        r0 = r5.mtopResponse;
        if (r0 != 0) goto L_0x0090;
    L_0x0079:
        r0 = new mtopsdk.mtop.domain.MtopResponse;
        r1 = r5.request;
        r1 = r1.getApiName();
        r2 = r5.request;
        r2 = r2.getVersion();
        r3 = "ANDROID_SYS_MTOP_APICALL_ASYNC_TIMEOUT";
        r4 = "MTOP异步调用超时";
        r0.<init>(r1, r2, r3, r4);
        r5.mtopResponse = r0;
    L_0x0090:
        r0 = r5.mtopResponse;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.MtopBusiness.syncRequest():mtopsdk.mtop.domain.MtopResponse");
    }

    private String genSeqNo() {
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("RB");
        stringBuilder.append(seqGen.getAndIncrement());
        stringBuilder.append('.');
        stringBuilder.append(this.stat.q);
        return stringBuilder.toString();
    }

    private void doQuery() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.request;
        r0 = r0.isNeedEcode();
        r1 = r4.isNeedAuth();
        if (r0 == 0) goto L_0x001d;
    L_0x000c:
        r2 = com.taobao.tao.remotebusiness.login.RemoteLogin.isSessionValid();
        if (r2 != 0) goto L_0x001d;
    L_0x0012:
        com.taobao.tao.remotebusiness.a.a(r4);
        r0 = r4.showLoginUI;
        r1 = r4.request;
        com.taobao.tao.remotebusiness.login.RemoteLogin.login(r0, r1);
        return;
    L_0x001d:
        if (r0 == 0) goto L_0x0062;
    L_0x001f:
        r2 = mtopsdk.xstate.a.a();	 Catch:{ Exception -> 0x005b }
        r2 = mtopsdk.common.util.i.b(r2);	 Catch:{ Exception -> 0x005b }
        if (r2 == 0) goto L_0x0062;	 Catch:{ Exception -> 0x005b }
    L_0x0029:
        r2 = r4.seqNo;	 Catch:{ Exception -> 0x005b }
        r3 = "[doQuery] session in loginContext is valid but XState's sid is null";	 Catch:{ Exception -> 0x005b }
        mtopsdk.common.util.j.c(r2, r3);	 Catch:{ Exception -> 0x005b }
        r2 = com.taobao.tao.remotebusiness.login.RemoteLogin.getLoginContext();	 Catch:{ Exception -> 0x005b }
        if (r2 == 0) goto L_0x0050;	 Catch:{ Exception -> 0x005b }
    L_0x0036:
        r3 = r2.sid;	 Catch:{ Exception -> 0x005b }
        r3 = mtopsdk.common.util.i.b(r3);	 Catch:{ Exception -> 0x005b }
        if (r3 != 0) goto L_0x0050;	 Catch:{ Exception -> 0x005b }
    L_0x003e:
        mtopsdk.mtop.a.d.a();	 Catch:{ Exception -> 0x005b }
        r3 = mtopsdk.mtop.a.d.b();	 Catch:{ Exception -> 0x005b }
        mtopsdk.mtop.b.a.a(r3);	 Catch:{ Exception -> 0x005b }
        r3 = r2.sid;	 Catch:{ Exception -> 0x005b }
        r2 = r2.userId;	 Catch:{ Exception -> 0x005b }
        mtopsdk.mtop.a.e.a(r3, r2);	 Catch:{ Exception -> 0x005b }
        goto L_0x0062;	 Catch:{ Exception -> 0x005b }
    L_0x0050:
        com.taobao.tao.remotebusiness.a.a(r4);	 Catch:{ Exception -> 0x005b }
        r2 = r4.showLoginUI;	 Catch:{ Exception -> 0x005b }
        r3 = r4.request;	 Catch:{ Exception -> 0x005b }
        com.taobao.tao.remotebusiness.login.RemoteLogin.login(r2, r3);	 Catch:{ Exception -> 0x005b }
        return;
    L_0x005b:
        r2 = r4.seqNo;
        r3 = "error happens in confirming session info";
        mtopsdk.common.util.j.b(r2, r3);
    L_0x0062:
        if (r0 == 0) goto L_0x009f;
    L_0x0064:
        if (r1 == 0) goto L_0x009f;
    L_0x0066:
        r0 = com.taobao.tao.remotebusiness.auth.RemoteAuth.isAuthInfoValid();
        r1 = 0;
        if (r0 != 0) goto L_0x007e;
    L_0x006d:
        com.taobao.tao.remotebusiness.a.a(r4);
        r0 = r4.authParam;
        r2 = r4.request;
        r2 = r2.getKey();
        r3 = r4.showAuthUI;
        com.taobao.tao.remotebusiness.auth.RemoteAuth.authorize(r0, r2, r1, r3);
        return;
    L_0x007e:
        r0 = com.taobao.tao.remotebusiness.auth.RemoteAuth.getAuthToken();
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x008e;
    L_0x0088:
        r1 = "accessToken";
        mtopsdk.xstate.a.a(r1, r0);
        goto L_0x009f;
    L_0x008e:
        com.taobao.tao.remotebusiness.a.a(r4);
        r0 = r4.authParam;
        r2 = r4.request;
        r2 = r2.getKey();
        r3 = r4.showAuthUI;
        com.taobao.tao.remotebusiness.auth.RemoteAuth.authorize(r0, r2, r1, r3);
        return;
    L_0x009f:
        r0 = java.lang.System.currentTimeMillis();
        r4.sendStartTime = r0;
        r0 = super.asyncRequest();
        r4.apiID = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.MtopBusiness.doQuery():void");
    }

    private void cancelRequest(boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x000f;
    L_0x0003:
        r4 = r3.seqNo;
        r1 = "cancelRequest.";
        r2 = 0;
        r1 = com.taobao.tao.remotebusiness.listener.c.a(r1, r3, r2, r0);
        mtopsdk.common.util.j.b(r4, r1);
    L_0x000f:
        r4 = 1;
        r3.isCanceled = r4;
        r1 = r3.apiID;
        if (r1 == 0) goto L_0x0033;
    L_0x0016:
        r1 = r3.apiID;	 Catch:{ Throwable -> 0x0028 }
        r2 = r1.a;	 Catch:{ Throwable -> 0x0028 }
        if (r2 != 0) goto L_0x0022;	 Catch:{ Throwable -> 0x0028 }
    L_0x001c:
        r1 = "Future is null,cancel apiCall failed";	 Catch:{ Throwable -> 0x0028 }
        mtopsdk.common.util.j.e(r1);	 Catch:{ Throwable -> 0x0028 }
        goto L_0x0033;	 Catch:{ Throwable -> 0x0028 }
    L_0x0022:
        r1 = r1.a;	 Catch:{ Throwable -> 0x0028 }
        r1.c();	 Catch:{ Throwable -> 0x0028 }
        goto L_0x0033;
    L_0x0028:
        r1 = r3.seqNo;
        r2 = "Cancel request task failed.";
        r4 = com.taobao.tao.remotebusiness.listener.c.a(r2, r3, r4, r0);
        mtopsdk.common.util.j.d(r1, r4);
    L_0x0033:
        com.taobao.tao.remotebusiness.a.b(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.MtopBusiness.cancelRequest(boolean):void");
    }
}
