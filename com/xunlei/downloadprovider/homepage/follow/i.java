package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.homepage.follow.b.f;

/* compiled from: FollowManager */
public final class i implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ b b;

    public i(b bVar, f fVar) {
        this.b = bVar;
        this.a = fVar;
    }

    public final void run() {
        if (this.b.e.b(this.a) == 0) {
            this.b.e.a(this.a);
        }
    }
}
