package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.IAuth.AuthCallback;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.request.Request.Builder;
import anet.channel.session.TnetSpdySession;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.statistics.c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.i;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class k extends b implements DataFrameCb {
    private boolean n = true;
    private ScheduledFuture<?> o = null;
    private Runnable p = new o(this);
    private Set<String> q;

    /* compiled from: Taobao */
    public static class a implements IAuth {
        private String a;
        private int b;
        private String c;
        private b d;

        public a(b bVar, String str) {
            this.c = bVar.d();
            StringBuilder stringBuilder = new StringBuilder("https://");
            stringBuilder.append(str);
            stringBuilder.append("/accs/");
            this.a = bVar.c(stringBuilder.toString());
            this.b = bVar.c;
            this.d = bVar;
        }

        public void auth(Session session, AuthCallback authCallback) {
            ALog.i(this.c, "auth begin", "seq", session.mSeq);
            String str = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(" auth URL:");
            stringBuilder.append(this.a);
            ALog.e(str, stringBuilder.toString(), new Object[0]);
            session.request(new Builder().setUrl(this.a).build(), new p(this, session, authCallback));
        }
    }

    public void a(boolean z, boolean z2) {
    }

    public c c() {
        return null;
    }

    public k(Context context, int i, String str) {
        super(context, i, str);
        if (i.a(true) == 0) {
            i = UtilityImpl.getTnetLogFilePath(this.d, "inapp");
            str = d();
            StringBuilder stringBuilder = new StringBuilder("config tnet log path:");
            stringBuilder.append(i);
            ALog.d(str, stringBuilder.toString(), new Object[0]);
            if (TextUtils.isEmpty(i) == null) {
                Session.configTnetALog(context, i, UtilityImpl.TNET_FILE_SIZE, 5);
            }
        }
        this.o = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.p, 120000, TimeUnit.MILLISECONDS);
    }

    public synchronized void a() {
        this.n = true;
        a(this.d);
        String d = d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" start");
        ALog.d(d, stringBuilder.toString(), new Object[0]);
    }

    protected void a(com.taobao.accs.data.Message r6, boolean r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r7 = r5.n;
        r0 = 0;
        if (r7 == 0) goto L_0x00b0;
    L_0x0005:
        if (r6 != 0) goto L_0x0009;
    L_0x0007:
        goto L_0x00b0;
    L_0x0009:
        r7 = com.taobao.accs.common.ThreadPoolExecutorFactory.getSendScheduledExecutor();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7 = r7.getQueue();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7 = r7.size();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        if (r7 <= r1) goto L_0x0021;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0019:
        r7 = new java.util.concurrent.RejectedExecutionException;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = "accs";	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7.<init>(r1);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        throw r7;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0021:
        r7 = com.taobao.accs.common.ThreadPoolExecutorFactory.getSendScheduledExecutor();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = new com.taobao.accs.net.l;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1.<init>(r5, r6);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r2 = r6.O;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7 = r7.schedule(r1, r2, r4);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = r6.a();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r2 = 1;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        if (r1 != r2) goto L_0x0059;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0039:
        r1 = r6.M;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        if (r1 == 0) goto L_0x0059;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x003d:
        r1 = r6.c();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        if (r1 == 0) goto L_0x0050;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0043:
        r1 = r6.M;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = r5.a(r1);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        if (r1 == 0) goto L_0x0050;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x004b:
        r1 = r5.e;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1.b(r6);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0050:
        r1 = r5.e;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = r1.a;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r2 = r6.M;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1.put(r2, r7);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0059:
        r7 = r6.e();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        if (r7 == 0) goto L_0x0070;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x005f:
        r1 = r5.d;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r1);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7.setDeviceId(r1);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r1 = r5.c;	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7.setConnType(r1);	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
        r7.onEnterQueueData();	 Catch:{ RejectedExecutionException -> 0x0084, Throwable -> 0x0071 }
    L_0x0070:
        return;
    L_0x0071:
        r7 = move-exception;
        r1 = r5.e;
        r2 = -8;
        r1.a(r6, r2);
        r6 = r5.d();
        r1 = "send error";
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.e(r6, r1, r7, r0);
        return;
    L_0x0084:
        r7 = r5.e;
        r1 = 70008; // 0x11178 float:9.8102E-41 double:3.45885E-319;
        r7.a(r6, r1);
        r6 = r5.d();
        r7 = new java.lang.StringBuilder;
        r1 = "send queue full count:";
        r7.<init>(r1);
        r1 = com.taobao.accs.common.ThreadPoolExecutorFactory.getSendScheduledExecutor();
        r1 = r1.getQueue();
        r1 = r1.size();
        r7.append(r1);
        r7 = r7.toString();
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.e(r6, r7, r0);
        return;
    L_0x00b0:
        r6 = r5.d();
        r7 = new java.lang.StringBuilder;
        r1 = "not running or msg null! ";
        r7.<init>(r1);
        r1 = r5.n;
        r7.append(r1);
        r7 = r7.toString();
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.e(r6, r7, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.k.a(com.taobao.accs.data.Message, boolean):void");
    }

    public void e() {
        String d = d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append("shut down");
        ALog.e(d, stringBuilder.toString(), new Object[0]);
        this.n = false;
    }

    public void b() {
        this.f = 0;
    }

    protected void a(String str, String str2) {
        try {
            str = this.e.a(str);
            if (!(str == null || str.f == null)) {
                str = SessionCenter.getInstance(this.i.getAppKey()).get(str.f.toString(), 0);
                if (str != null) {
                    str.checkAvailable();
                }
            }
        } catch (String str3) {
            ALog.e(d(), "onTimeOut", str3, new Object[0]);
        }
    }

    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i, int i2) {
        if (ALog.isPrintLog(Level.I) != 0) {
            i = d();
            StringBuilder stringBuilder = new StringBuilder("onDataReceive, type:");
            stringBuilder.append(i2);
            stringBuilder.append(" len:");
            stringBuilder.append(bArr.length);
            ALog.i(i, stringBuilder.toString(), new Object[0]);
        }
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new m(this, i2, bArr, tnetSpdySession));
        if (ALog.isPrintLog(Level.E) != null) {
            ALog.e(d(), "onDataReceive, end:", new Object[0]);
        }
    }

    public void onException(int i, int i2, boolean z, String str) {
        String d = d();
        StringBuilder stringBuilder = new StringBuilder("errorId:");
        stringBuilder.append(i2);
        stringBuilder.append("detail:");
        stringBuilder.append(str);
        stringBuilder.append(" dataId:");
        stringBuilder.append(i);
        stringBuilder.append(" needRetry:");
        stringBuilder.append(z);
        ALog.e(d, stringBuilder.toString(), new Object[0]);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new n(this, i, z, i2));
    }

    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.e.a.get(str);
        boolean cancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (cancel) {
            ALog.e(d(), "cancel", "customDataId", str);
        }
        return cancel;
    }

    protected String d() {
        StringBuilder stringBuilder = new StringBuilder("InAppConn_");
        stringBuilder.append(this.m);
        return stringBuilder.toString();
    }

    protected void a(Context context) {
        try {
            if (!this.g) {
                boolean z;
                super.a(context);
                context = this.i.getInappHost();
                if (h() && this.i.isKeepalive()) {
                    z = true;
                } else {
                    ALog.i(d(), "close keepalive", new Object[0]);
                    z = false;
                }
                a(SessionCenter.getInstance(Config.getConfigByTag(this.i.getAppKey())), context, z);
                this.g = true;
                ALog.e(d(), "init awcn success!", new Object[0]);
            }
        } catch (Context context2) {
            ALog.e(d(), "initAwcn", context2, new Object[0]);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z) {
        if (this.q == null) {
            this.q = new HashSet(2);
        }
        if (!this.q.contains(str)) {
            sessionCenter.registerSessionInfo(SessionInfo.create(str, z, true, new a(this, str), null, this));
            sessionCenter.registerPublicKey(str, this.i.getInappPubKey());
            this.q.add(str);
            ALog.i(d(), "registerSessionInfo", "host", str);
        }
    }

    public void a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            ALog.i(d(), "updateConfig null", new Object[0]);
            return;
        }
        try {
            boolean z;
            ALog.i("InAppConn_", "updateConfig", "old", this.i.toString(), "new", accsClientConfig.toString());
            this.i = accsClientConfig;
            this.b = this.i.getAppKey();
            this.m = this.i.getTag();
            accsClientConfig = SessionCenter.getInstance(this.i.getAppKey());
            accsClientConfig.unregisterSessionInfo(this.i.getInappHost());
            if (h() && this.i.isKeepalive()) {
                z = true;
            } else {
                ALog.i(d(), "close keepalive", new Object[0]);
                z = false;
            }
            a(accsClientConfig, this.i.getInappHost(), z);
        } catch (AccsClientConfig accsClientConfig2) {
            ALog.i("InAppConn_", "updateConfig", "excetion", accsClientConfig2.toString());
        }
    }
}
