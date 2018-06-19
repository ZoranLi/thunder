package com.xunlei.downloadprovider.personal.liked;

import java.util.List;

/* compiled from: LikeCinecismFragment */
final class d implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ c b;

    d(c cVar, List list) {
        this.b = cVar;
        this.a = list;
    }

    public final void run() {
        if (this.b.b.a != null && this.b.b.a.getItemCount() == 0 && this.a.isEmpty()) {
            this.b.b.c.setVisibility(0);
        }
        this.b.b.b.setLoadingMoreEnabled(false);
    }
}
