package com.xunlei.downloadprovider.ad.splash.c;

import android.os.SystemClock;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.t;
import com.xunlei.downloadprovider.ad.common.g;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.ad.splash.b.b;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.loading.c;
import java.util.List;

/* compiled from: SplashAdModel */
public final class a {
    private static a b;
    public com.xunlei.downloadprovider.ad.common.h.a a;
    private boolean c;
    private boolean d;
    private List<l> e;
    private int f;
    private String g;
    private g h;

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private a() {
        this.a = null;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = -1;
        this.g = "";
        this.h = null;
        this.h = new g();
    }

    public static void b() {
        a a = a();
        a.e();
        a.h.a.put(Integer.valueOf(1000), Long.valueOf(-1));
        b = null;
    }

    public final void c() {
        e();
        j.c();
        int i = 0;
        j.a(b.b(0));
        if (!c.b() && d.a().p.b() && com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            i = 1;
        }
        if (i == 0) {
            a(-16, "should not load splash ad.");
            return;
        }
        g gVar = this.h;
        long currentTimeMillis = System.currentTimeMillis();
        gVar.a.put(Integer.valueOf(1000), Long.valueOf(currentTimeMillis));
        com.xunlei.downloadprovider.ad.revive.a.a.a.a().f = SystemClock.uptimeMillis();
        new t().a(THUNDER_AD_INFO.SPLASH, new b(this, currentTimeMillis), -1, true);
    }

    private void e() {
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = -1;
        this.g = "";
    }

    public final void d() {
        if (this.a == null || !this.c) {
            return;
        }
        if (this.d) {
            this.a.a(this.e);
        } else {
            this.a.a(this.f, this.g);
        }
    }

    private void a(int i, String str) {
        this.c = true;
        this.d = false;
        this.f = i;
        this.g = str;
    }

    static /* synthetic */ void a(a aVar, List list) {
        aVar.c = true;
        aVar.d = true;
        aVar.e = list;
    }
}
