package com.xunlei.downloadprovider.homepage;

import com.xunlei.downloadprovider.search.ui.search.bq;

/* compiled from: HomeFragment */
final class j implements Runnable {
    final /* synthetic */ HomeFragment a;

    j(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void run() {
        bq.a().a(this.a.u);
        this.a.u = bq.a().a;
        this.a.h.setHint(this.a.u);
        this.a.f.postDelayed(this.a.g, StatisticConfig.MIN_UPLOAD_INTERVAL);
    }
}
