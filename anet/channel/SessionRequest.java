package anet.channel;

import android.content.Context;
import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.entity.EventType;
import anet.channel.session.TnetSpdySession;
import anet.channel.session.d;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.c;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
class SessionRequest {
    String a;
    SessionCenter b;
    f c;
    volatile boolean d = false;
    volatile Session e;
    volatile boolean f = false;
    SessionConnStat g = null;
    private String h;
    private SessionInfo i;
    private volatile Future j;
    private Object k = new Object();

    /* compiled from: Taobao */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[EventType.values().length];

        static {
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
            r0 = anet.channel.entity.EventType.values();
            r0 = r0.length;
            r0 = new int[r0];
            a = r0;
            r0 = a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = anet.channel.entity.EventType.AUTH_SUCC;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = anet.channel.entity.EventType.DISCONNECTED;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = anet.channel.entity.EventType.CONNECT_FAIL;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionRequest.1.<clinit>():void");
        }
    }

    /* compiled from: Taobao */
    private interface IConnCb {
        void onDisConnect(Session session, long j, EventType eventType);

        void onFailed(Session session, long j, EventType eventType, int i);

        void onSuccess(Session session, long j);
    }

    /* compiled from: Taobao */
    private class b implements Runnable {
        String a = null;
        final /* synthetic */ SessionRequest b;

        b(SessionRequest sessionRequest, String str) {
            this.b = sessionRequest;
            this.a = str;
        }

        public void run() {
            if (this.b.d) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.a, new Object[0]);
                if (this.b.e != null) {
                    this.b.e.tryNextWhenFail = false;
                    this.b.e.close();
                }
                this.b.a(false);
            }
        }
    }

    /* compiled from: Taobao */
    class a implements IConnCb {
        boolean a = null;
        final /* synthetic */ SessionRequest b;
        private Context c;
        private List<anet.channel.entity.a> d;
        private anet.channel.entity.a e;

        a(SessionRequest sessionRequest, Context context, List<anet.channel.entity.a> list, anet.channel.entity.a aVar) {
            this.b = sessionRequest;
            this.c = context;
            this.d = list;
            this.e = aVar;
        }

        public void onFailed(Session session, long j, EventType eventType, int i) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "Connect failed", this.e.h(), "session", session, "host", this.b.a(), "isHandleFinish", Boolean.valueOf(this.a));
            }
            if (this.b.f) {
                this.b.f = false;
            } else if (!this.a) {
                this.a = true;
                this.b.c.b(this.b, session);
                if (session.tryNextWhenFail && NetworkStatusHelper.g()) {
                    if (!this.d.isEmpty()) {
                        if (ALog.isPrintLog(1)) {
                            ALog.d("awcn.SessionRequest", "use next connInfo to create session", this.e.h(), "host", this.b.a());
                        }
                        if (this.e.b == this.e.c && (i == -2003 || i == -2410)) {
                            j = this.d.listIterator();
                            while (j.hasNext()) {
                                if (session.getIp().equals(((anet.channel.entity.a) j.next()).a.getIp())) {
                                    j.remove();
                                }
                            }
                        }
                        anet.channel.entity.a aVar = (anet.channel.entity.a) this.d.remove(0);
                        this.b.a(this.c, aVar, new a(this.b, this.c, this.d, aVar), aVar.h());
                        return;
                    }
                }
                this.b.c();
                if (!(EventType.CONNECT_FAIL.equals(eventType) == null || i == -2613 || i == -2601)) {
                    session = new AlarmObject();
                    session.module = "networkPrefer";
                    session.modulePoint = "policy";
                    session.arg = this.b.a;
                    session.errorCode = String.valueOf(i);
                    session.isSuccess = false;
                    AppMonitor.getInstance().commitAlarm(session);
                    this.b.g.errorCode = String.valueOf(i);
                    this.b.g.costTime = System.currentTimeMillis() - this.b.g.startTime;
                    AppMonitor.getInstance().commitStat(this.b.g);
                }
            }
        }

        public void onSuccess(Session session, long j) {
            ALog.d("awcn.SessionRequest", "Connect Success", this.e.h(), "session", session, "host", this.b.a());
            try {
                if (this.b.f != null) {
                    this.b.f = false;
                    session.close(false);
                    this.b.c();
                    return;
                }
                this.b.c.a(this.b, session);
                session = new AlarmObject();
                session.module = "networkPrefer";
                session.modulePoint = "policy";
                session.arg = this.b.a;
                session.isSuccess = true;
                AppMonitor.getInstance().commitAlarm(session);
                this.b.g.ret = 1;
                if (this.e.a != null) {
                    this.b.g.succIpType = this.e.a.getIpType();
                }
                this.b.g.costTime = System.currentTimeMillis() - this.b.g.startTime;
                AppMonitor.getInstance().commitStat(this.b.g);
                this.b.c();
            } catch (Session session2) {
                ALog.e("awcn.SessionRequest", "[onSuccess]:", this.e.h(), session2, new Object[0]);
            } catch (Throwable th) {
                this.b.c();
            }
        }

        public void onDisConnect(anet.channel.Session r8, long r9, anet.channel.entity.EventType r11) {
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
            r9 = anet.channel.GlobalAppRuntimeInfo.isAppBackground();
            r10 = "awcn.SessionRequest";
            r11 = "Connect Disconnect";
            r0 = r7.e;
            r0 = r0.h();
            r1 = 8;
            r1 = new java.lang.Object[r1];
            r2 = "session";
            r3 = 0;
            r1[r3] = r2;
            r2 = 1;
            r1[r2] = r8;
            r4 = "host";
            r5 = 2;
            r1[r5] = r4;
            r4 = r7.b;
            r4 = r4.a();
            r6 = 3;
            r1[r6] = r4;
            r4 = "appIsBg";
            r6 = 4;
            r1[r6] = r4;
            r4 = java.lang.Boolean.valueOf(r9);
            r6 = 5;
            r1[r6] = r4;
            r4 = "isHandleFinish";
            r6 = 6;
            r1[r6] = r4;
            r4 = r7.a;
            r4 = java.lang.Boolean.valueOf(r4);
            r6 = 7;
            r1[r6] = r4;
            anet.channel.util.ALog.d(r10, r11, r0, r1);
            r10 = r7.b;
            r10 = r10.c;
            r11 = r7.b;
            r10.b(r11, r8);
            r10 = r7.a;
            if (r10 == 0) goto L_0x0053;
        L_0x0052:
            return;
        L_0x0053:
            r7.a = r2;
            r10 = r8.autoReCreate;
            if (r10 != 0) goto L_0x005a;
        L_0x0059:
            return;
        L_0x005a:
            if (r9 == 0) goto L_0x0072;
        L_0x005c:
            r9 = "awcn.SessionRequest";
            r10 = "[onDisConnect]app background, don't Recreate";
            r11 = r7.e;
            r11 = r11.h();
            r0 = new java.lang.Object[r5];
            r1 = "session";
            r0[r3] = r1;
            r0[r2] = r8;
            anet.channel.util.ALog.e(r9, r10, r11, r0);
            return;
        L_0x0072:
            r9 = anet.channel.status.NetworkStatusHelper.g();
            if (r9 != 0) goto L_0x008e;
        L_0x0078:
            r9 = "awcn.SessionRequest";
            r10 = "[onDisConnect]no network, don't Recreate";
            r11 = r7.e;
            r11 = r11.h();
            r0 = new java.lang.Object[r5];
            r1 = "session";
            r0[r3] = r1;
            r0[r2] = r8;
            anet.channel.util.ALog.e(r9, r10, r11, r0);
            return;
        L_0x008e:
            r9 = "awcn.SessionRequest";	 Catch:{ Exception -> 0x00b6 }
            r10 = "session disconnected, try to recreate session";	 Catch:{ Exception -> 0x00b6 }
            r11 = r7.e;	 Catch:{ Exception -> 0x00b6 }
            r11 = r11.h();	 Catch:{ Exception -> 0x00b6 }
            r0 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00b6 }
            anet.channel.util.ALog.d(r9, r10, r11, r0);	 Catch:{ Exception -> 0x00b6 }
            r9 = new anet.channel.i;	 Catch:{ Exception -> 0x00b6 }
            r9.<init>(r7, r8);	 Catch:{ Exception -> 0x00b6 }
            r10 = java.lang.Math.random();	 Catch:{ Exception -> 0x00b6 }
            r0 = 4621819117588971520; // 0x4024000000000000 float:0.0 double:10.0;	 Catch:{ Exception -> 0x00b6 }
            r10 = r10 * r0;	 Catch:{ Exception -> 0x00b6 }
            r0 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;	 Catch:{ Exception -> 0x00b6 }
            r10 = r10 * r0;	 Catch:{ Exception -> 0x00b6 }
            r10 = (long) r10;	 Catch:{ Exception -> 0x00b6 }
            r8 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x00b6 }
            anet.channel.a.c.a(r9, r10, r8);	 Catch:{ Exception -> 0x00b6 }
            return;
        L_0x00b6:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionRequest.a.onDisConnect(anet.channel.Session, long, anet.channel.entity.EventType):void");
        }
    }

    SessionRequest(String str, SessionCenter sessionCenter) {
        this.a = str;
        this.h = this.a.substring(this.a.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.b = sessionCenter;
        this.i = sessionCenter.attributeManager.b(this.h);
        this.c = sessionCenter.sessionPool;
    }

    protected String a() {
        return this.a;
    }

    void a(boolean z) {
        this.d = z;
        if (!z) {
            if (this.j) {
                this.j.cancel(true);
                this.j = null;
            }
            this.e = null;
        }
    }

    protected synchronized void a(android.content.Context r11, anet.channel.entity.ConnType.TypeLevel r12, java.lang.String r13) throws anet.channel.NoNetworkException, anet.channel.NoAvailStrategyException {
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
        r10 = this;
        monitor-enter(r10);
        r0 = r10.c;	 Catch:{ all -> 0x00ee }
        r0 = r0.a(r10, r12);	 Catch:{ all -> 0x00ee }
        r1 = 0;	 Catch:{ all -> 0x00ee }
        if (r0 == 0) goto L_0x0015;	 Catch:{ all -> 0x00ee }
    L_0x000a:
        r11 = "awcn.SessionRequest";	 Catch:{ all -> 0x00ee }
        r12 = "Available Session exist!!!";	 Catch:{ all -> 0x00ee }
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x00ee }
        anet.channel.util.ALog.d(r11, r12, r13, r0);	 Catch:{ all -> 0x00ee }
        monitor-exit(r10);
        return;
    L_0x0015:
        r0 = android.text.TextUtils.isEmpty(r13);	 Catch:{ all -> 0x00ee }
        if (r0 == 0) goto L_0x0020;	 Catch:{ all -> 0x00ee }
    L_0x001b:
        r13 = 0;	 Catch:{ all -> 0x00ee }
        r13 = anet.channel.util.g.a(r13);	 Catch:{ all -> 0x00ee }
    L_0x0020:
        r0 = "awcn.SessionRequest";	 Catch:{ all -> 0x00ee }
        r2 = "SessionRequest start";	 Catch:{ all -> 0x00ee }
        r3 = 4;	 Catch:{ all -> 0x00ee }
        r4 = new java.lang.Object[r3];	 Catch:{ all -> 0x00ee }
        r5 = "host";	 Catch:{ all -> 0x00ee }
        r4[r1] = r5;	 Catch:{ all -> 0x00ee }
        r5 = r10.a;	 Catch:{ all -> 0x00ee }
        r6 = 1;	 Catch:{ all -> 0x00ee }
        r4[r6] = r5;	 Catch:{ all -> 0x00ee }
        r5 = "type";	 Catch:{ all -> 0x00ee }
        r7 = 2;	 Catch:{ all -> 0x00ee }
        r4[r7] = r5;	 Catch:{ all -> 0x00ee }
        r5 = 3;	 Catch:{ all -> 0x00ee }
        r4[r5] = r12;	 Catch:{ all -> 0x00ee }
        anet.channel.util.ALog.d(r0, r2, r13, r4);	 Catch:{ all -> 0x00ee }
        r0 = r10.d;	 Catch:{ all -> 0x00ee }
        if (r0 == 0) goto L_0x0054;	 Catch:{ all -> 0x00ee }
    L_0x003f:
        r11 = "awcn.SessionRequest";	 Catch:{ all -> 0x00ee }
        r12 = "session is connecting, return";	 Catch:{ all -> 0x00ee }
        r0 = new java.lang.Object[r7];	 Catch:{ all -> 0x00ee }
        r2 = "host";	 Catch:{ all -> 0x00ee }
        r0[r1] = r2;	 Catch:{ all -> 0x00ee }
        r1 = r10.a();	 Catch:{ all -> 0x00ee }
        r0[r6] = r1;	 Catch:{ all -> 0x00ee }
        anet.channel.util.ALog.d(r11, r12, r13, r0);	 Catch:{ all -> 0x00ee }
        monitor-exit(r10);
        return;
    L_0x0054:
        r10.a(r6);	 Catch:{ all -> 0x00ee }
        r0 = new anet.channel.SessionRequest$b;	 Catch:{ all -> 0x00ee }
        r0.<init>(r10, r13);	 Catch:{ all -> 0x00ee }
        r8 = 45;	 Catch:{ all -> 0x00ee }
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00ee }
        r0 = anet.channel.a.c.a(r0, r8, r2);	 Catch:{ all -> 0x00ee }
        r10.j = r0;	 Catch:{ all -> 0x00ee }
        r0 = new anet.channel.statist.SessionConnStat;	 Catch:{ all -> 0x00ee }
        r0.<init>();	 Catch:{ all -> 0x00ee }
        r10.g = r0;	 Catch:{ all -> 0x00ee }
        r0 = r10.g;	 Catch:{ all -> 0x00ee }
        r2 = r10.a;	 Catch:{ all -> 0x00ee }
        r0.host = r2;	 Catch:{ all -> 0x00ee }
        r0 = r10.g;	 Catch:{ all -> 0x00ee }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00ee }
        r0.startTime = r8;	 Catch:{ all -> 0x00ee }
        r0 = anet.channel.status.NetworkStatusHelper.g();	 Catch:{ all -> 0x00ee }
        if (r0 != 0) goto L_0x00a7;	 Catch:{ all -> 0x00ee }
    L_0x0081:
        r11 = anet.channel.util.ALog.isPrintLog(r6);	 Catch:{ all -> 0x00ee }
        if (r11 == 0) goto L_0x009e;	 Catch:{ all -> 0x00ee }
    L_0x0087:
        r11 = "awcn.SessionRequest";	 Catch:{ all -> 0x00ee }
        r12 = "network is not available, can't create session";	 Catch:{ all -> 0x00ee }
        r0 = new java.lang.Object[r7];	 Catch:{ all -> 0x00ee }
        r2 = "NetworkStatusHelper.isConnected()";	 Catch:{ all -> 0x00ee }
        r0[r1] = r2;	 Catch:{ all -> 0x00ee }
        r1 = anet.channel.status.NetworkStatusHelper.g();	 Catch:{ all -> 0x00ee }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x00ee }
        r0[r6] = r1;	 Catch:{ all -> 0x00ee }
        anet.channel.util.ALog.d(r11, r12, r13, r0);	 Catch:{ all -> 0x00ee }
    L_0x009e:
        r10.c();	 Catch:{ all -> 0x00ee }
        r11 = new anet.channel.NoNetworkException;	 Catch:{ all -> 0x00ee }
        r11.<init>(r10);	 Catch:{ all -> 0x00ee }
        throw r11;	 Catch:{ all -> 0x00ee }
    L_0x00a7:
        r0 = r10.a(r12, r13);	 Catch:{ all -> 0x00ee }
        r2 = r0.isEmpty();	 Catch:{ all -> 0x00ee }
        if (r2 == 0) goto L_0x00d1;	 Catch:{ all -> 0x00ee }
    L_0x00b1:
        r11 = "awcn.SessionRequest";	 Catch:{ all -> 0x00ee }
        r0 = "no avalible strategy, can't create session";	 Catch:{ all -> 0x00ee }
        r2 = new java.lang.Object[r3];	 Catch:{ all -> 0x00ee }
        r3 = "host";	 Catch:{ all -> 0x00ee }
        r2[r1] = r3;	 Catch:{ all -> 0x00ee }
        r1 = r10.a;	 Catch:{ all -> 0x00ee }
        r2[r6] = r1;	 Catch:{ all -> 0x00ee }
        r1 = "type";	 Catch:{ all -> 0x00ee }
        r2[r7] = r1;	 Catch:{ all -> 0x00ee }
        r2[r5] = r12;	 Catch:{ all -> 0x00ee }
        anet.channel.util.ALog.i(r11, r0, r13, r2);	 Catch:{ all -> 0x00ee }
        r10.c();	 Catch:{ all -> 0x00ee }
        r11 = new anet.channel.NoAvailStrategyException;	 Catch:{ all -> 0x00ee }
        r11.<init>(r10);	 Catch:{ all -> 0x00ee }
        throw r11;	 Catch:{ all -> 0x00ee }
    L_0x00d1:
        r12 = r10.a(r0, r13);	 Catch:{ all -> 0x00ee }
        r13 = r12.remove(r1);	 Catch:{ Throwable -> 0x00e9 }
        r13 = (anet.channel.entity.a) r13;	 Catch:{ Throwable -> 0x00e9 }
        r0 = new anet.channel.SessionRequest$a;	 Catch:{ Throwable -> 0x00e9 }
        r0.<init>(r10, r11, r12, r13);	 Catch:{ Throwable -> 0x00e9 }
        r12 = r13.h();	 Catch:{ Throwable -> 0x00e9 }
        r10.a(r11, r13, r0, r12);	 Catch:{ Throwable -> 0x00e9 }
        monitor-exit(r10);
        return;
    L_0x00e9:
        r10.c();	 Catch:{ all -> 0x00ee }
        monitor-exit(r10);
        return;
    L_0x00ee:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionRequest.a(android.content.Context, anet.channel.entity.ConnType$TypeLevel, java.lang.String):void");
    }

    private List<IConnStrategy> a(TypeLevel typeLevel, String str) {
        List<IConnStrategy> connStrategyListByHost;
        try {
            c a = c.a(a());
            if (a == null) {
                return Collections.EMPTY_LIST;
            }
            connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(a.b());
            try {
                if (!connStrategyListByHost.isEmpty()) {
                    boolean equalsIgnoreCase = "https".equalsIgnoreCase(a.a());
                    ListIterator listIterator = connStrategyListByHost.listIterator();
                    while (listIterator.hasNext()) {
                        ConnType valueOf = ConnType.valueOf(((IConnStrategy) listIterator.next()).getProtocol());
                        if (!(valueOf.isSSL() == equalsIgnoreCase && (typeLevel == null || valueOf.getTypeLevel() == typeLevel))) {
                            listIterator.remove();
                        }
                    }
                }
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", connStrategyListByHost);
                }
            } catch (Throwable th) {
                typeLevel = th;
                ALog.e("awcn.SessionRequest", "", str, typeLevel, new Object[0]);
                return connStrategyListByHost;
            }
            return connStrategyListByHost;
        } catch (Throwable th2) {
            typeLevel = th2;
            connStrategyListByHost = Collections.EMPTY_LIST;
            ALog.e("awcn.SessionRequest", "", str, typeLevel, new Object[0]);
            return connStrategyListByHost;
        }
    }

    private List<anet.channel.entity.a> a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<anet.channel.entity.a> arrayList = new ArrayList();
        int i = 0;
        int i2 = i;
        while (i < list.size()) {
            IConnStrategy iConnStrategy = (IConnStrategy) list.get(i);
            int retryTimes = iConnStrategy.getRetryTimes();
            int i3 = i2;
            for (i2 = 0; i2 <= retryTimes; i2++) {
                i3++;
                String a = a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("_");
                stringBuilder.append(i3);
                anet.channel.entity.a aVar = new anet.channel.entity.a(a, stringBuilder.toString(), iConnStrategy);
                aVar.b = i2;
                aVar.c = retryTimes;
                arrayList.add(aVar);
            }
            i++;
            i2 = i3;
        }
        return arrayList;
    }

    private void a(Context context, anet.channel.entity.a aVar, IConnCb iConnCb, String str) {
        ConnType c = aVar.c();
        if (context == null || c.isHttpType()) {
            this.e = new d(context, aVar);
        } else {
            this.e = new TnetSpdySession(context, aVar, this.b.config, this.i, this.b.attributeManager.c(this.h));
        }
        ALog.i("awcn.SessionRequest", "create connection...", str, HttpConstant.HOST, a(), "Type", aVar.c(), "IP", aVar.a(), "Port", Integer.valueOf(aVar.b()), "heartbeat", Integer.valueOf(aVar.g()), "session", this.e);
        a(this.e, iConnCb, System.currentTimeMillis());
        this.e.connect();
        context = this.g;
        context.retryTimes += 1;
        if (this.g.retryTimes == 1 && aVar.a != null) {
            this.g.firstIpType = aVar.a.getIpType();
        }
    }

    private void a(Session session, IConnCb iConnCb, long j) {
        if (iConnCb != null) {
            session.registerEventcb(EventType.ALL.getType(), new g(this, iConnCb, j));
            session.registerEventcb((EventType.AUTH_SUCC.getType() | EventType.CONNECT_FAIL.getType()) | EventType.AUTH_FAIL.getType(), new h(this, session));
        }
    }

    protected void b(boolean z) {
        ALog.d("awcn.SessionRequest", "closeSessions", null, "host", this.a, "autoCreate", Boolean.valueOf(z));
        if (!(z || this.e == null)) {
            this.e.tryNextWhenFail = false;
            this.e.close(false);
        }
        List<Session> a = this.c.a(this);
        if (a != null) {
            for (Session session : a) {
                if (session != null) {
                    session.close(z);
                }
            }
        }
    }

    protected void a(String str) {
        ALog.d("awcn.SessionRequest", "reCreateSession", str, "host", this.a);
        b(true);
    }

    protected void a(long j) throws InterruptedException, TimeoutException {
        ALog.d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j));
        if (j > 0) {
            synchronized (this.k) {
                long currentTimeMillis = System.currentTimeMillis() + j;
                while (this.d != null) {
                    j = System.currentTimeMillis();
                    if (j >= currentTimeMillis) {
                        break;
                    }
                    this.k.wait(currentTimeMillis - j);
                }
                if (this.d != null) {
                    throw new TimeoutException();
                }
            }
        }
    }

    protected TypeLevel b() {
        Session session = this.e;
        return session != null ? session.mConnType.getTypeLevel() : null;
    }

    void c() {
        a(false);
        synchronized (this.k) {
            this.k.notifyAll();
        }
    }

    void a(Session session, int i, String str) {
        Context context = GlobalAppRuntimeInfo.getContext();
        if (!(context == null || this.i == null)) {
            if (this.i.isAccs) {
                try {
                    Intent intent = new Intent(Constants.ACTION_RECEIVE);
                    intent.setPackage(context.getPackageName());
                    intent.setClassName(context, com.taobao.accs.utl.a.msgService);
                    intent.putExtra("command", 103);
                    intent.putExtra("host", session.getHost());
                    intent.putExtra(Constants.KEY_CENTER_HOST, true);
                    session = session.isAvailable();
                    if (session == null) {
                        intent.putExtra("errorCode", i);
                        intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
                    }
                    intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, session);
                    intent.putExtra(Constants.KEY_TYPE_INAPP, true);
                    context.startService(intent);
                } catch (Session session2) {
                    ALog.e("awcn.SessionRequest", "sendConnectInfoBroadCastToAccs", null, session2, new Object[0]);
                }
            }
        }
    }
}
