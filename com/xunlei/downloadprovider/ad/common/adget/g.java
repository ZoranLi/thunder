package com.xunlei.downloadprovider.ad.common.adget;

import com.xunlei.downloadprovider.ad.common.n;

/* compiled from: AgGet */
final class g implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ e b;

    g(e eVar, n nVar) {
        this.b = eVar;
        this.a = nVar;
    }

    public final void run() {
        this.b.b(this.a);
    }
}
