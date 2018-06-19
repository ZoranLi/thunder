package com.xunlei.downloadprovider.homepage.youliao;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.homepage.a.a;

/* compiled from: YouliaoVideoFragment */
final class b implements a {
    final /* synthetic */ YouliaoVideoFragment a;

    public final int d() {
        return 30;
    }

    b(YouliaoVideoFragment youliaoVideoFragment) {
        this.a = youliaoVideoFragment;
    }

    public final void a() {
        this.a.b();
    }

    public final long b() {
        return f.b(BrothersApplication.getApplicationInstance(), "auto_refresh_time_home_youliao_tab", 0);
    }

    public final void c() {
        f.a(BrothersApplication.getApplicationInstance(), "auto_refresh_time_home_youliao_tab", System.currentTimeMillis());
    }
}
