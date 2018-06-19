package com.xunlei.downloadprovider.d;

import android.content.Context;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.a.a;
import com.xunlei.downloadprovider.b.f;
import com.xunlei.downloadprovider.contentpublish.website.a.m;

/* compiled from: ConfigureManager */
public final class c {
    private static c a = new c();

    private c() {
    }

    public static c a() {
        return a;
    }

    public static void a(Context context) {
        e a = e.a();
        VolleyRequestManager.init(context);
        XLThreadPool.execute(new f(a));
    }

    public static void b() {
        e a = e.a();
        a.d = true;
        a.c();
        l.a().g();
        d.a().i();
        m.a().h();
        b.a().h();
        f.a().h();
        a.a().g();
        i.a().h();
        m.a().h();
    }

    public static void c() {
        i.a().i();
        m.a().h();
    }

    public static void d() {
        b.a().i();
        m.a().i();
        f.a().i();
        m.a().c();
    }

    public static void e() {
        e a = e.a();
        if (a.b || !a.d) {
            long currentTimeMillis = System.currentTimeMillis();
            if (a.c > 0 && a.c + 28800000 <= currentTimeMillis) {
                a.c();
            }
            return;
        }
        a.c();
    }
}
