package com.xunlei.downloadprovider.homepage.follow.c;

import java.util.List;

/* compiled from: FollowNetworkHelper */
final class g implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ f c;

    g(f fVar, List list, boolean z) {
        this.c = fVar;
        this.a = list;
        this.b = z;
    }

    public final void run() {
        this.c.a.c.a(this.a, Boolean.valueOf(this.b));
    }
}
