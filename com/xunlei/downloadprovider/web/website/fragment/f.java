package com.xunlei.downloadprovider.web.website.fragment;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.web.website.a;

/* compiled from: CollectionAndHistoryFragment */
final class f implements Runnable {
    final /* synthetic */ CollectionAndHistoryFragment a;

    f(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        this.a = collectionAndHistoryFragment;
    }

    public final void run() {
        this.a.e.setVisibility(8);
        LoginHelper.a();
        if (l.c()) {
            a.a().b();
        }
    }
}
