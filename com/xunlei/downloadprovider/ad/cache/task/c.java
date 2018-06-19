package com.xunlei.downloadprovider.ad.cache.task;

import com.xunlei.downloadprovider.ad.cache.a.b;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;

/* compiled from: DetectNetworkTask */
public final class c extends b implements a {
    private boolean e = true;

    public c(b bVar) {
        super(bVar);
    }

    public final void c() {
        super.c();
        ADCacheNetworkReceiver.a(this);
    }

    public final void a(boolean z) {
        if (this.d && !this.e && z) {
            for (STYLES_INFO a : this.c) {
                this.b.a(a);
            }
        }
        this.e = false;
    }
}
