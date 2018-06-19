package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.crashreport.crash.anr.b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ag;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
public class c {
    public static int a = 0;
    public static boolean b = false;
    public static int c = 2;
    public static boolean d = true;
    public static int e = 20000;
    public static int f = 20000;
    public static long g = 604800000;
    public static String h = null;
    public static boolean i = false;
    public static String j = null;
    public static int k = 5000;
    public static boolean l = true;
    public static String m;
    public static String n;
    private static c u;
    public final b o;
    public final a p = a.a();
    public final am q;
    public BuglyStrategy.a r;
    public f s;
    private final Context t;
    private final e v;
    private final NativeCrashHandler w;
    private final b x;
    private Boolean y;

    protected c(int i, Context context, am amVar, boolean z, BuglyStrategy.a aVar, f fVar, String str) {
        a = i;
        Context a = ap.a(context);
        this.t = a;
        am amVar2 = amVar;
        this.q = amVar2;
        BuglyStrategy.a aVar2 = aVar;
        this.r = aVar2;
        f fVar2 = fVar;
        this.s = fVar2;
        ak a2 = ak.a();
        ae a3 = ae.a();
        this.o = new b(i, a, a2, a3, this.p, aVar2, fVar2);
        com.tencent.bugly.crashreport.common.info.a a4 = com.tencent.bugly.crashreport.common.info.a.a(a);
        this.v = new e(a, this.o, this.p, a4);
        am amVar3 = amVar2;
        this.w = NativeCrashHandler.getInstance(a, a4, this.o, this.p, amVar3, z, str);
        a4.J = this.w;
        this.x = new b(a, this.p, a4, amVar3, a3, this.o, aVar2);
    }

    public static synchronized void a(int i, Context context, boolean z, BuglyStrategy.a aVar, f fVar, String str) {
        synchronized (c.class) {
            if (u == null) {
                u = new c(i, context, am.a(), z, aVar, fVar, str);
            }
        }
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = u;
        }
        return cVar;
    }

    public void a(StrategyBean strategyBean) {
        this.v.a(strategyBean);
        this.w.onStrategyChanged(strategyBean);
        this.x.a(strategyBean);
        a(0);
    }

    public boolean b() {
        Boolean bool = this.y;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().e;
        List<ag> a = ae.a().a(1);
        List arrayList = new ArrayList();
        if (a == null || a.size() <= 0) {
            this.y = Boolean.valueOf(false);
            return false;
        }
        for (ag agVar : a) {
            if (str.equals(agVar.c)) {
                this.y = Boolean.valueOf(true);
                arrayList.add(agVar);
            }
        }
        if (arrayList.size() > 0) {
            ae.a().a(arrayList);
        }
        return true;
    }

    public synchronized void c() {
        f();
        h();
        i();
    }

    public synchronized void d() {
        e();
        g();
        j();
    }

    public void e() {
        this.v.b();
    }

    public void f() {
        this.v.a();
    }

    public void g() {
        this.w.setUserOpened(false);
    }

    public void h() {
        this.w.setUserOpened(true);
    }

    public void i() {
        this.x.b(true);
    }

    public void j() {
        this.x.b(false);
    }

    public synchronized void k() {
        this.w.testNativeCrash();
    }

    public synchronized void l() {
        this.x.g();
    }

    public boolean m() {
        return this.x.a();
    }

    public void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        final boolean z3 = z;
        final Thread thread2 = thread;
        final Throwable th2 = th;
        final String str2 = str;
        final byte[] bArr2 = bArr;
        final boolean z4 = z2;
        this.q.a(new Runnable(this) {
            final /* synthetic */ c g;

            public void run() {
                try {
                    an.c("post a throwable %b", Boolean.valueOf(z3));
                    this.g.v.b(thread2, th2, false, str2, bArr2);
                    if (z4) {
                        an.a("clear user datas", new Object[0]);
                        com.tencent.bugly.crashreport.common.info.a.a(this.g.t).C();
                    }
                } catch (Throwable th) {
                    if (!an.b(th)) {
                        th.printStackTrace();
                    }
                    an.e("java catch error: %s", th2.toString());
                }
            }
        });
    }

    public void a(CrashDetailBean crashDetailBean) {
        this.o.e(crashDetailBean);
    }

    public void a(long j) {
        am.a().a(new Thread(this) {
            final /* synthetic */ c a;

            {
                this.a = r1;
            }

            public void run() {
                if (ap.a(this.a.t, "local_crash_lock", 10000)) {
                    List a = this.a.o.a();
                    if (a != null && a.size() > 0) {
                        List list;
                        int size = a.size();
                        if (((long) size) > 100) {
                            List arrayList = new ArrayList();
                            Collections.sort(a);
                            for (int i = 0; ((long) i) < 100; i++) {
                                arrayList.add(a.get((size - 1) - i));
                            }
                            list = arrayList;
                        } else {
                            list = a;
                        }
                        this.a.o.a(list, 0, false, false, false);
                    }
                    ap.b(this.a.t, "local_crash_lock");
                }
            }
        }, j);
    }
}
