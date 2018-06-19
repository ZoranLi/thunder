package com.xunlei.downloadprovider.contentpublish.website;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: WebsiteEditActivity */
final class as implements OnDismissListener {
    final /* synthetic */ WebsiteEditActivity a;

    as(WebsiteEditActivity websiteEditActivity) {
        this.a = websiteEditActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        az.a().a(this.a.g());
    }
}
