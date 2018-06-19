package com.xunlei.downloadprovider.web.website.fragment;

import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.web.website.g.j;

/* compiled from: CollectionAndHistoryFragment */
final class b extends c {
    final /* synthetic */ CollectionAndHistoryFragment a;

    b(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        this.a = collectionAndHistoryFragment;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z && "CollectionAndHistoryFragment".equals(obj)) {
            j.a().a(this.a.n);
        }
        j.a().a = false;
    }
}
