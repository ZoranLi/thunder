package com.xunlei.downloadprovider.homepage.follow;

import java.util.List;

/* compiled from: FollowManager */
public final class r implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    public r(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    public final void run() {
        this.b.e.c();
        this.b.e.a(this.a);
    }
}
