package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.homepage.follow.b;

/* compiled from: HistoryPublishItemFragment */
final class aw implements Runnable {
    final /* synthetic */ av a;

    aw(av avVar) {
        this.a = avVar;
    }

    public final void run() {
        if (!b.a().b(this.a.a.c)) {
            this.a.a.a();
        }
    }
}
