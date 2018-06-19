package com.xunlei.downloadprovider.ad.c.c;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.c.a.d;
import com.xunlei.downloadprovider.ad.c.a.e;
import com.xunlei.downloadprovider.ad.c.a.g;

/* compiled from: SplashMaterialClearTask */
public final class b extends g implements com.xunlei.downloadprovider.ad.c.a.b {
    private final e a = new d("clear_splash_material_time");

    protected final long d() {
        return 1209600000;
    }

    public final void a() {
        XLThreadPool.execute(new c(this));
    }

    protected final long b() {
        return this.a.a();
    }

    protected final void c() {
        this.a.a(System.currentTimeMillis());
    }
}
