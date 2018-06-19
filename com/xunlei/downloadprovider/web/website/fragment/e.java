package com.xunlei.downloadprovider.web.website.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: CollectionAndHistoryFragment */
final class e implements OnClickListener {
    final /* synthetic */ CollectionAndHistoryFragment a;

    e(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        this.a = collectionAndHistoryFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.c();
        }
    }
}
