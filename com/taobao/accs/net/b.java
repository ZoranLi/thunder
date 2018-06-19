package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsClientConfig.Builder;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.a;
import com.taobao.accs.ut.statistics.c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public abstract class b {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;
    public String a;
    public String b = "";
    protected int c;
    protected Context d;
    protected a e;
    protected int f = 0;
    protected volatile boolean g = false;
    public com.taobao.accs.client.b h;
    public AccsClientConfig i;
    protected String j;
    protected String k = null;
    protected LinkedHashMap<Integer, Message> l = new BaseConnection$1(this);
    public String m;
    private long n = 0;
    private Runnable o;
    private ScheduledFuture<?> p;

    protected String a(int i) {
        switch (i) {
            case 1:
                return "CONNECTED";
            case 2:
                return "CONNECTING";
            case 3:
                return "DISCONNECTED";
            case 4:
                return "DISCONNECTING";
            default:
                return "DISCONNECTED";
        }
    }

    public abstract void a();

    protected abstract void a(Message message, boolean z);

    protected abstract void a(String str, String str2);

    public abstract void a(boolean z, boolean z2);

    public abstract boolean a(String str);

    public abstract void b();

    public abstract c c();

    protected abstract String d();

    public void e() {
    }

    protected boolean h() {
        return true;
    }

    protected b(Context context, int i, String str) {
        this.c = i;
        this.d = context.getApplicationContext();
        i = AccsClientConfig.getConfigByTag(str);
        if (i == 0) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                i = new Builder().setAppKey(ACCSManager.getDefaultAppkey(context)).setTag(str).build();
            } catch (String str2) {
                ALog.e(d(), "BaseConnection build config", str2, new Object[0]);
            }
        }
        this.m = i.getTag();
        this.b = i.getAppKey();
        this.i = i;
        this.e = new a(context, this);
        this.e.b = this.c;
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), 5000, TimeUnit.MILLISECONDS);
    }

    public void b(com.taobao.accs.data.Message r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r10.c;
        r1 = 0;
        if (r0 != 0) goto L_0x002e;
    L_0x0005:
        r0 = r9.d;
        r0 = com.taobao.accs.utl.UtilityImpl.isNetworkConnected(r0);
        if (r0 != 0) goto L_0x002e;
    L_0x000d:
        r11 = r9.d();
        r0 = new java.lang.StringBuilder;
        r2 = "no network:";
        r0.<init>(r2);
        r2 = r10.q;
        r0.append(r2);
        r0 = r0.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r11, r0, r1);
        r11 = r9.e;
        r0 = -13;
        r11.a(r10, r0);
        return;
    L_0x002e:
        r0 = r10.a();
        r2 = 2;
        r3 = 0;
        if (r0 == r2) goto L_0x0044;
    L_0x0037:
        r0 = r9.e;
        r0 = r0.d;
        r5 = r10.F;
        r6 = r10.T;
        r5 = r0.a(r5, r6);
        goto L_0x0045;
    L_0x0044:
        r5 = r3;
    L_0x0045:
        r7 = -1;
        r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r0 != 0) goto L_0x006d;
    L_0x004b:
        r11 = r9.d();
        r0 = new java.lang.StringBuilder;
        r2 = "servier limit high. dataId:";
        r0.<init>(r2);
        r2 = r10.q;
        r0.append(r2);
        r0 = r0.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r11, r0, r1);
        r11 = r9.e;
        r0 = 70021; // 0x11185 float:9.812E-41 double:3.4595E-319;
        r11.a(r10, r0);
        return;
    L_0x006d:
        r7 = -1000; // 0xfffffffffffffc18 float:NaN double:NaN;
        r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r0 != 0) goto L_0x0095;
    L_0x0073:
        r11 = r9.d();
        r0 = new java.lang.StringBuilder;
        r2 = "servier limit high for brush. dataId:";
        r0.<init>(r2);
        r2 = r10.q;
        r0.append(r2);
        r0 = r0.toString();
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r11, r0, r1);
        r11 = r9.e;
        r0 = 70023; // 0x11187 float:9.8123E-41 double:3.4596E-319;
        r11.a(r10, r0);
        return;
    L_0x0095:
        r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r0 <= 0) goto L_0x00f1;
    L_0x0099:
        r3 = java.lang.System.currentTimeMillis();
        r7 = r9.n;
        r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r0 <= 0) goto L_0x00a6;
    L_0x00a3:
        r10.O = r5;
        goto L_0x00b2;
    L_0x00a6:
        r3 = r9.n;
        r7 = r3 + r5;
        r3 = java.lang.System.currentTimeMillis();
        r5 = r7 - r3;
        r10.O = r5;
    L_0x00b2:
        r3 = java.lang.System.currentTimeMillis();
        r5 = r10.O;
        r7 = r3 + r5;
        r9.n = r7;
        r0 = r9.d();
        r3 = new java.lang.StringBuilder;
        r4 = "send message, ";
        r3.<init>(r4);
        r4 = r10.a();
        r4 = com.taobao.accs.data.Message.b.b(r4);
        r3.append(r4);
        r4 = " delay:";
        r3.append(r4);
        r4 = r10.O;
        r3.append(r4);
        r4 = " dataId:";
        r3.append(r4);
        r4 = r10.q;
        r3.append(r4);
        r3 = r3.toString();
        r4 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r0, r3, r4);
        goto L_0x016a;
    L_0x00f1:
        r0 = "accs";
        r3 = r10.F;
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x012f;
    L_0x00fb:
        r0 = r9.d();
        r3 = new java.lang.StringBuilder;
        r4 = "send message, ";
        r3.<init>(r4);
        r4 = r10.a();
        r4 = com.taobao.accs.data.Message.b.b(r4);
        r3.append(r4);
        r4 = " delay:";
        r3.append(r4);
        r4 = r10.O;
        r3.append(r4);
        r4 = " dataId:";
        r3.append(r4);
        r4 = r10.q;
        r3.append(r4);
        r3 = r3.toString();
        r4 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r0, r3, r4);
        goto L_0x016a;
    L_0x012f:
        r0 = com.taobao.accs.utl.ALog.Level.D;
        r0 = com.taobao.accs.utl.ALog.isPrintLog(r0);
        if (r0 == 0) goto L_0x016a;
    L_0x0137:
        r0 = r9.d();
        r3 = new java.lang.StringBuilder;
        r4 = "send message, ";
        r3.<init>(r4);
        r4 = r10.a();
        r4 = com.taobao.accs.data.Message.b.b(r4);
        r3.append(r4);
        r4 = " delay:";
        r3.append(r4);
        r4 = r10.O;
        r3.append(r4);
        r4 = " dataId:";
        r3.append(r4);
        r4 = r10.q;
        r3.append(r4);
        r3 = r3.toString();
        r4 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.d(r0, r3, r4);
    L_0x016a:
        r0 = r9.j;	 Catch:{ RejectedExecutionException -> 0x018c }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ RejectedExecutionException -> 0x018c }
        if (r0 == 0) goto L_0x017a;	 Catch:{ RejectedExecutionException -> 0x018c }
    L_0x0172:
        r0 = r9.d;	 Catch:{ RejectedExecutionException -> 0x018c }
        r0 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r0);	 Catch:{ RejectedExecutionException -> 0x018c }
        r9.j = r0;	 Catch:{ RejectedExecutionException -> 0x018c }
    L_0x017a:
        r0 = r10.g();	 Catch:{ RejectedExecutionException -> 0x018c }
        if (r0 != 0) goto L_0x0184;	 Catch:{ RejectedExecutionException -> 0x018c }
    L_0x0180:
        r9.a(r10, r11);	 Catch:{ RejectedExecutionException -> 0x018c }
        return;	 Catch:{ RejectedExecutionException -> 0x018c }
    L_0x0184:
        r11 = r9.e;	 Catch:{ RejectedExecutionException -> 0x018c }
        r0 = -9;	 Catch:{ RejectedExecutionException -> 0x018c }
        r11.a(r10, r0);	 Catch:{ RejectedExecutionException -> 0x018c }
        return;
    L_0x018c:
        r11 = r9.e;
        r0 = 70008; // 0x11178 float:9.8102E-41 double:3.45885E-319;
        r11.a(r10, r0);
        r10 = r9.d();
        r11 = "msg queue full";
        r0 = new java.lang.Object[r2];
        r2 = "size";
        r0[r1] = r2;
        r1 = 1;
        r2 = com.taobao.accs.common.ThreadPoolExecutorFactory.getSendScheduledExecutor();
        r2 = r2.getQueue();
        r2 = r2.size();
        r2 = java.lang.Integer.valueOf(r2);
        r0[r1] = r2;
        com.taobao.accs.utl.ALog.e(r10, r11, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.b.b(com.taobao.accs.data.Message, boolean):void");
    }

    protected void a(String str, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new d(this, str), j, TimeUnit.MILLISECONDS);
    }

    protected boolean a(Message message, int i) {
        boolean z = true;
        try {
            if (message.P > 3) {
                return false;
            }
            message.P++;
            message.O = (long) i;
            i = d();
            StringBuilder stringBuilder = new StringBuilder("reSend dataid:");
            stringBuilder.append(message.q);
            stringBuilder.append(" retryTimes:");
            stringBuilder.append(message.P);
            ALog.e(i, stringBuilder.toString(), new Object[0]);
            b(message, true);
            try {
                if (message.e() != 0) {
                    message.e().take_date = 0;
                    message.e().to_tnet_date = 0;
                    message.e().retry_times = message.P;
                    if (message.P == 1) {
                        com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                    }
                }
            } catch (Throwable th) {
                i = th;
                this.e.a(message, -8);
                ALog.e(d(), "reSend error", i, new Object[0]);
                return z;
            }
            return z;
        } catch (Throwable th2) {
            i = th2;
            z = false;
            this.e.a(message, -8);
            ALog.e(d(), "reSend error", i, new Object[0]);
            return z;
        }
    }

    protected void b(int i) {
        if (i < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i));
            Message message = (Message) this.l.get(Integer.valueOf(i));
            if (message != null) {
                a(message, (int) ReaderCallback.GET_BAR_ANIMATING);
                com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    protected void f() {
        if (this.o == null) {
            this.o = new e(this);
        }
        g();
        this.p = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.o, anet.channel.Constants.RECV_TIMEOUT, TimeUnit.MILLISECONDS);
    }

    protected void g() {
        if (this.p != null) {
            this.p.cancel(true);
        }
    }

    public String b(String str) {
        String inappHost = this.i.getInappHost();
        StringBuilder stringBuilder = new StringBuilder("https://");
        stringBuilder.append(TextUtils.isEmpty(str) ? "" : str);
        stringBuilder.append(inappHost);
        String stringBuilder2 = stringBuilder.toString();
        try {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            stringBuilder3.append(str);
            stringBuilder3.append(inappHost);
            return stringBuilder3.toString();
        } catch (String str2) {
            ALog.e("InAppConnection", "getHost", str2, new Object[0]);
            return stringBuilder2;
        }
    }

    protected void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            if (AccsClientConfig.mEnv == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (AccsClientConfig.mEnv == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.b).setAppSecret(this.i.getAppSecret()).setAuthCode(this.i.getAuthCode()).setEnv(env).setTag(this.i.getAppKey()).build());
            context = ConnType.PK_ACS;
            if (this.i.getInappPubKey() == 10 || this.i.getInappPubKey() == 11) {
                context = "open";
            }
            StrategyTemplate.getInstance().registerConnProtocol(this.i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, context, false));
        } catch (Context context2) {
            ALog.e(d(), "initAwcn", context2, new Object[0]);
        }
    }

    public void b(Message message, int i) {
        this.e.a(message, i);
    }

    public String i() {
        return this.b;
    }

    public com.taobao.accs.client.b j() {
        if (this.h == null) {
            this.h = new com.taobao.accs.client.b(this.d, this.m);
        }
        return this.h;
    }

    public void b(Context context) {
        try {
            ThreadPoolExecutorFactory.schedule(new f(this, context), 10000, TimeUnit.MILLISECONDS);
        } catch (Context context2) {
            ALog.w(d(), "startChannelService", context2, new Object[0]);
        }
    }

    protected String c(String str) {
        String deviceId = UtilityImpl.getDeviceId(this.d);
        try {
            deviceId = URLEncoder.encode(deviceId);
        } catch (Throwable th) {
            ALog.e(d(), "encode", th, new Object[0]);
        }
        String appsign = UtilityImpl.getAppsign(this.d, i(), this.i.getAppSecret(), UtilityImpl.getDeviceId(this.d), this.m);
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(str);
        stringBuilder.append("auth?1=");
        stringBuilder.append(deviceId);
        stringBuilder.append("&2=");
        stringBuilder.append(appsign);
        stringBuilder.append("&3=");
        stringBuilder.append(i());
        if (this.k != null) {
            stringBuilder.append("&4=");
            stringBuilder.append(this.k);
        }
        stringBuilder.append("&5=");
        stringBuilder.append(this.c);
        stringBuilder.append("&6=");
        stringBuilder.append(UtilityImpl.getNetworkType(this.d));
        stringBuilder.append("&7=");
        stringBuilder.append(UtilityImpl.getOperator(this.d));
        stringBuilder.append("&8=");
        stringBuilder.append(this.c == 1 ? anet.channel.Constants.SDK_VERSION_CODE : Integer.valueOf(221));
        stringBuilder.append("&9=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("&10=1&11=");
        stringBuilder.append(VERSION.SDK_INT);
        stringBuilder.append("&12=");
        stringBuilder.append(this.d.getPackageName());
        stringBuilder.append("&13=");
        stringBuilder.append(UtilityImpl.getAppVersion(this.d));
        stringBuilder.append("&14=");
        stringBuilder.append(this.a);
        stringBuilder.append("&15=");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("&16=");
        stringBuilder.append(Build.BRAND);
        stringBuilder.append("&17=221");
        stringBuilder.append("&19=");
        stringBuilder.append(k() ^ 1);
        return stringBuilder.toString();
    }

    public boolean k() {
        return 2 == this.i.getSecurity();
    }
}
