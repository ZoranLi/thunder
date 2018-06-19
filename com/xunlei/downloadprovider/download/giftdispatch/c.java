package com.xunlei.downloadprovider.download.giftdispatch;

import com.xunlei.downloadprovider.download.tasklist.list.banner.a.e;
import java.util.List;

/* compiled from: GiftDispatchingActivity */
final class c implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    c(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    public final void run() {
        e.c().b(100);
        GiftDispatchingActivity.a(this.b.a, this.a);
    }
}
