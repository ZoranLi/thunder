package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchContentFragment */
final class au implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ SearchContentFragment b;

    au(SearchContentFragment searchContentFragment, String str) {
        this.b = searchContentFragment;
        this.a = str;
    }

    public final void run() {
        i.a().a(this.a, 0);
    }
}
