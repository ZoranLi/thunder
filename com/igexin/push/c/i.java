package com.igexin.push.c;

import com.igexin.b.a.b.c;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.util.a;

public class i {
    public static boolean a = false;
    private static final String b = "com.igexin.push.c.i";
    private static i c;
    private static h d;

    private i() {
        b();
        d = a.d() ? h.WIFI : h.MOBILE;
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (c == null) {
                c = new i();
            }
            iVar = c;
        }
        return iVar;
    }

    public void b() {
        a = SDKUrlConfig.realXfrListIsOnly();
    }

    public void c() {
        if (a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|xfr len = 1, detect = false");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return;
        }
        c.b().a(k.c_(), false, true);
    }

    public void d() {
        try {
            i().d();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    public a e() {
        return i().d;
    }

    public boolean f() {
        if (a) {
            return false;
        }
        m i = i();
        if (i.m()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|network changed detect = true, reset detect delay");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            i.f();
            return true;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(b);
        stringBuilder2.append("|startDetect detect = false");
        com.igexin.b.a.c.a.b(stringBuilder2.toString());
        return false;
    }

    public String g() {
        if (a) {
            return SDKUrlConfig.getXfrAddress()[0];
        }
        m i = i();
        if (i != null) {
            j g = i.g();
            if (g != null) {
                return g.g();
            }
        }
        return null;
    }

    public void h() {
        b();
        if (a) {
            k.c_().g();
            try {
                l.a().d.a(null);
                r.a().d.a(null);
                r.a().i();
                l.a().i();
                r.a().l();
                return;
            } catch (Throwable th) {
                Throwable th2 = th;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b);
                stringBuilder.append("|");
                stringBuilder.append(th2.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
        try {
            r.a().l();
            r.a().h();
            l.a().h();
            m i = i();
            if (i != null) {
                i.j();
            }
        } catch (Throwable th3) {
            th2 = th3;
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|");
            stringBuilder.append(th2.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    public m i() {
        m a;
        StringBuilder stringBuilder;
        if (a.d()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|wifi state");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            a = r.a();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|mobile state");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            a = l.a();
        }
        h b = a.b();
        if (b != d) {
            if (b == h.WIFI) {
                l.a().e();
            } else if (b == h.MOBILE) {
                r.a().e();
            }
        }
        d = b;
        return a;
    }
}
