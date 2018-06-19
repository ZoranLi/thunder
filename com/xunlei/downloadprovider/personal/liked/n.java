package com.xunlei.downloadprovider.personal.liked;

import java.util.List;

/* compiled from: LikeShortVideoFragment */
final class n implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ m b;

    n(m mVar, List list) {
        this.b = mVar;
        this.a = list;
    }

    public final void run() {
        if (this.b.b.b != null && this.b.b.b.getItemCount() == 0 && this.a.isEmpty()) {
            this.b.b.c.setVisibility(0);
        }
        this.b.b.a.setLoadingMoreEnabled(false);
    }
}
