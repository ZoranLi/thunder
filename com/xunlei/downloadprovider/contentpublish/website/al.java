package com.xunlei.downloadprovider.contentpublish.website;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* compiled from: WebsiteDetailFragment */
final class al extends OnScrollListener {
    final /* synthetic */ WebsiteDetailFragment a;

    al(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        recyclerView = WebsiteDetailFragment.a;
        WebsiteDetailFragment.a(this.a, i);
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
    }
}
