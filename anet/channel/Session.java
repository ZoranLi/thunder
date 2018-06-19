package anet.channel;

import android.content.Context;
import anet.channel.a.c;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.entity.EventType;
import anet.channel.entity.a;
import anet.channel.entity.d;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* compiled from: Taobao */
public abstract class Session implements Comparable<Session> {
    private static final String TAG = "awcn.Session";
    protected boolean autoReCreate = false;
    protected IConnStrategy mConnStrategy;
    protected int mConnTimeout;
    protected ConnType mConnType;
    protected Context mContext;
    Map<EventCb, Integer> mEventCallBacks = new LinkedHashMap();
    protected String mHost;
    protected String mIp;
    private boolean mIsConnTimeOut = false;
    protected int mPort;
    protected String mProxyIp;
    protected int mProxyPort;
    protected String mRealHost;
    protected Runnable mRecvTimeOutRunnable;
    protected int mReqTimeout;
    public final String mSeq;
    public final SessionStatistic mSessionStat;
    protected Status mStatus = Status.DISCONNECTED;
    private Future<?> timeoutTaskFuture;
    protected boolean tryNextWhenFail = true;

    /* compiled from: Taobao */
    public enum Status {
        CONNECTED,
        CONNECTING,
        CONNETFAIL,
        AUTHING,
        AUTH_SUCC,
        AUTH_FAIL,
        DISCONNECTED,
        DISCONNECTING
    }

    public abstract void close();

    public void connect() {
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public abstract boolean isAvailable();

    public void onDisconnect() {
    }

    public void ping(boolean z) {
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i, byte[] bArr, int i2) {
    }

    public int compareTo(Session session) {
        return ConnType.compare(this.mConnType, session.mConnType);
    }

    public Session(Context context, a aVar, ConnType connType) {
        this.mContext = context;
        this.mIp = aVar.a();
        this.mPort = aVar.b();
        this.mConnType = connType;
        this.mHost = aVar.f();
        this.mRealHost = this.mHost.substring(this.mHost.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.mReqTimeout = aVar.e();
        this.mConnTimeout = aVar.d();
        this.mConnStrategy = aVar.a;
        this.mSessionStat = new SessionStatistic(aVar);
        this.mSeq = aVar.h();
    }

    public void checkAvailable() {
        ping(true);
    }

    public static void configTnetALog(Context context, String str, int i, int i2) {
        context = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (context == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", new Object[]{Boolean.valueOf(SpdyAgent.checkLoadSucc())});
            return;
        }
        context.configLogFile(str, i, i2);
    }

    public void close(boolean z) {
        this.autoReCreate = z;
        close();
    }

    public void registerEventcb(int i, EventCb eventCb) {
        if (this.mEventCallBacks != null) {
            this.mEventCallBacks.put(eventCb, Integer.valueOf(i));
        }
    }

    protected void unReceiveEventCb(EventCb eventCb) {
        if (this.mEventCallBacks != null) {
            this.mEventCallBacks.remove(eventCb);
        }
    }

    public String getIp() {
        return this.mIp;
    }

    public int getPort() {
        return this.mPort;
    }

    public ConnType getConnType() {
        return this.mConnType;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getRealHost() {
        return this.mRealHost;
    }

    public IConnStrategy getConnStrategy() {
        return this.mConnStrategy;
    }

    protected void handleCallbacks(EventType eventType, d dVar) {
        c.a(new b(this, eventType, dVar));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected synchronized void notifyStatus(anet.channel.Session.Status r8, anet.channel.entity.d r9) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = "awcn.Session";
        r1 = "notifyStatus";
        r2 = r7.mSeq;	 Catch:{ all -> 0x006f }
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x006f }
        r4 = "status";
        r5 = 0;
        r3[r5] = r4;	 Catch:{ all -> 0x006f }
        r4 = 1;
        r6 = r8.name();	 Catch:{ all -> 0x006f }
        r3[r4] = r6;	 Catch:{ all -> 0x006f }
        anet.channel.util.ALog.e(r0, r1, r2, r3);	 Catch:{ all -> 0x006f }
        r0 = r7.mStatus;	 Catch:{ all -> 0x006f }
        r0 = r8.equals(r0);	 Catch:{ all -> 0x006f }
        if (r0 == 0) goto L_0x002e;
    L_0x0021:
        r8 = "awcn.Session";
        r9 = "ignore notifyStatus";
        r0 = r7.mSeq;	 Catch:{ all -> 0x006f }
        r1 = new java.lang.Object[r5];	 Catch:{ all -> 0x006f }
        anet.channel.util.ALog.i(r8, r9, r0, r1);	 Catch:{ all -> 0x006f }
        monitor-exit(r7);
        return;
    L_0x002e:
        r7.mStatus = r8;	 Catch:{ all -> 0x006f }
        r8 = anet.channel.Session.AnonymousClass1.a;	 Catch:{ all -> 0x006f }
        r0 = r7.mStatus;	 Catch:{ all -> 0x006f }
        r0 = r0.ordinal();	 Catch:{ all -> 0x006f }
        r8 = r8[r0];	 Catch:{ all -> 0x006f }
        switch(r8) {
            case 1: goto L_0x006b;
            case 2: goto L_0x0064;
            case 3: goto L_0x0062;
            case 4: goto L_0x005b;
            case 5: goto L_0x004d;
            case 6: goto L_0x004b;
            case 7: goto L_0x0044;
            case 8: goto L_0x003e;
            default: goto L_0x003d;
        };	 Catch:{ all -> 0x006f }
    L_0x003d:
        goto L_0x006d;
    L_0x003e:
        r8 = anet.channel.entity.EventType.AUTH_FAIL;	 Catch:{ all -> 0x006f }
        r7.handleCallbacks(r8, r9);	 Catch:{ all -> 0x006f }
        goto L_0x006d;
    L_0x0044:
        r8 = anet.channel.entity.EventType.AUTH_SUCC;	 Catch:{ all -> 0x006f }
        r7.handleCallbacks(r8, r9);	 Catch:{ all -> 0x006f }
        monitor-exit(r7);
        return;
    L_0x004b:
        monitor-exit(r7);
        return;
    L_0x004d:
        r7.onDisconnect();	 Catch:{ all -> 0x006f }
        r8 = r7.mIsConnTimeOut;	 Catch:{ all -> 0x006f }
        if (r8 != 0) goto L_0x006d;
    L_0x0054:
        r8 = anet.channel.entity.EventType.DISCONNECTED;	 Catch:{ all -> 0x006f }
        r7.handleCallbacks(r8, r9);	 Catch:{ all -> 0x006f }
        monitor-exit(r7);
        return;
    L_0x005b:
        r8 = anet.channel.entity.EventType.CONNECT_FAIL;	 Catch:{ all -> 0x006f }
        r7.handleCallbacks(r8, r9);	 Catch:{ all -> 0x006f }
        monitor-exit(r7);
        return;
    L_0x0062:
        monitor-exit(r7);
        return;
    L_0x0064:
        r8 = anet.channel.entity.EventType.CONNECTED;	 Catch:{ all -> 0x006f }
        r7.handleCallbacks(r8, r9);	 Catch:{ all -> 0x006f }
        monitor-exit(r7);
        return;
    L_0x006b:
        monitor-exit(r7);
        return;
    L_0x006d:
        monitor-exit(r7);
        return;
    L_0x006f:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.Session.notifyStatus(anet.channel.Session$Status, anet.channel.entity.d):void");
    }

    protected void setPingTimeout() {
        if (this.mRecvTimeOutRunnable == null) {
            this.mRecvTimeOutRunnable = getRecvTimeOutRunnable();
        }
        cancelTimeout();
        if (this.mRecvTimeOutRunnable != null) {
            this.timeoutTaskFuture = c.a(this.mRecvTimeOutRunnable, Constants.RECV_TIMEOUT, TimeUnit.MILLISECONDS);
        }
    }

    protected void cancelTimeout() {
        if (this.mRecvTimeOutRunnable != null && this.timeoutTaskFuture != null) {
            this.timeoutTaskFuture.cancel(true);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Session@[");
        stringBuilder.append(this.mSeq);
        stringBuilder.append('|');
        stringBuilder.append(this.mConnType);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
