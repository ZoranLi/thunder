package com.xunlei.downloadprovider.personal.liked;

import java.util.List;

/* compiled from: LikeCinecismFragment */
final class e implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ c b;

    e(c cVar, List list) {
        this.b = cVar;
        this.a = list;
    }

    public final void run() {
        this.b.b.a.a(this.a);
        this.b.b.b(2);
    }
}
