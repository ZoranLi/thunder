package com.xunlei.downloadprovider.homepage.follow;

import java.util.List;

/* compiled from: FollowManager */
final class n implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ m b;

    n(m mVar, List list) {
        this.b = mVar;
        this.a = list;
    }

    public final void run() {
        this.b.a.onSuccess(this.a);
    }
}
