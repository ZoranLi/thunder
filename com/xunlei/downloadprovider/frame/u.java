package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.discovery.kuainiao.d;

/* compiled from: MainTabActivity */
final class u implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ MainTabActivity b;

    u(MainTabActivity mainTabActivity, boolean z) {
        this.b = mainTabActivity;
        this.a = z;
    }

    public final void run() {
        if (this.a && d.b() && !MainTabActivity.c(this.b)) {
            this.b.b(true);
        }
    }
}
