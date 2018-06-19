package com.xunlei.downloadprovider.discovery;

import com.xunlei.downloadprovider.discovery.kuainiao.d;

/* compiled from: DiscoveryFragment */
final class f implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    f(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public final void run() {
        if (this.b.a.isVisible() && this.a == 0) {
            d.a().d();
            this.b.a.l = false;
            this.b.a.c();
        }
    }
}
