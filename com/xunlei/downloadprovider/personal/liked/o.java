package com.xunlei.downloadprovider.personal.liked;

import java.util.List;

/* compiled from: LikeShortVideoFragment */
final class o implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ m b;

    o(m mVar, List list) {
        this.b = mVar;
        this.a = list;
    }

    public final void run() {
        this.b.b.b.a(this.a);
        this.b.b.a(2);
    }
}
