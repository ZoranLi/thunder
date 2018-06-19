package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: WebsiteDetailActivity */
final class b implements OnClickListener {
    final /* synthetic */ WebsiteDetailActivity a;

    b(WebsiteDetailActivity websiteDetailActivity) {
        this.a = websiteDetailActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
