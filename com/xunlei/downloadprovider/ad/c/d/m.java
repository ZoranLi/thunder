package com.xunlei.downloadprovider.ad.c.d;

import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.concurrent.TimeUnit;

/* compiled from: ReportSelfInstalledAppsTask */
public class m extends h {
    private static final String a = "m";
    private static final long b = TimeUnit.DAYS.toMillis(7);

    public final void a() {
        f.d();
        e[] a = a.a(BrothersApplication.getApplicationInstance().getApplicationContext());
        for (e eVar : a) {
            new StringBuilder("\napp: ").append(eVar.toString());
        }
        h.a(false, a);
        c();
    }

    protected final long b() {
        return com.xunlei.downloadprovider.h.f.b(BrothersApplication.getApplicationInstance().getApplicationContext(), "report_self_installed_apps_time", 0);
    }

    protected final void c() {
        new StringBuilder("recordLatelyExecuteTime currentTime: ").append(System.currentTimeMillis());
        com.xunlei.downloadprovider.h.f.a(BrothersApplication.getApplicationInstance().getApplicationContext(), "report_self_installed_apps_time", System.currentTimeMillis());
    }

    protected final long d() {
        return b;
    }
}
