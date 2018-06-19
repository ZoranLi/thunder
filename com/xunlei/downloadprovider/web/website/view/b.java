package com.xunlei.downloadprovider.web.website.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CollectionUserSyncTipView */
final class b implements OnClickListener {
    final /* synthetic */ CollectionUserSyncTipView a;

    b(CollectionUserSyncTipView collectionUserSyncTipView) {
        this.a = collectionUserSyncTipView;
    }

    public final void onClick(View view) {
        if (this.a.c != null) {
            this.a.c.onClick(view);
        }
    }
}
