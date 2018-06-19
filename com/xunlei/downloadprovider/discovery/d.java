package com.xunlei.downloadprovider.discovery;

import com.xunlei.downloadprovider.search.ui.search.bq;

/* compiled from: DiscoveryFragment */
final class d implements Runnable {
    final /* synthetic */ DiscoveryFragment a;

    d(DiscoveryFragment discoveryFragment) {
        this.a = discoveryFragment;
    }

    public final void run() {
        bq.a().a(this.a.s);
        this.a.s = bq.a().a;
        this.a.d.setHint(this.a.s);
        this.a.a.postDelayed(this.a.b, StatisticConfig.MIN_UPLOAD_INTERVAL);
    }
}
