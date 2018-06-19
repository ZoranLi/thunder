package com.xunlei.downloadprovider.contentpublish.website;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: WebsiteDetailFragment */
final class j implements OnDismissListener {
    final /* synthetic */ WebsiteDetailFragment a;

    j(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.ab = true;
        this.a.h.setText(this.a.s.b());
    }
}
