package com.xunlei.downloadprovider.web.website.fragment;

/* compiled from: CollectionAndHistoryFragment */
final class g implements Runnable {
    final /* synthetic */ CollectionAndHistoryFragment a;

    g(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        this.a = collectionAndHistoryFragment;
    }

    public final void run() {
        if (this.a.r != null) {
            if (this.a.c != 1002) {
                if (this.a.c != 1003) {
                    if (this.a.c == 1000) {
                        CollectionAndHistoryFragment.f(this.a);
                        return;
                    } else if (this.a.c == 1001) {
                        CollectionAndHistoryFragment.g(this.a);
                    }
                }
            }
            CollectionAndHistoryFragment.f(this.a);
            CollectionAndHistoryFragment.g(this.a);
        }
    }
}
