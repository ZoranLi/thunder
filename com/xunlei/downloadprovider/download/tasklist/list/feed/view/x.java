package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;

/* compiled from: WebsiteViewHolder */
final class x implements OnClickListener {
    final /* synthetic */ v a;

    x(v vVar) {
        this.a = vVar;
    }

    public final void onClick(View view) {
        WebsiteDetailActivity.a(view.getContext(), this.a.h, this.a.g, v.b(this.a.mAdapter.a()));
        b.a(this.a.f, "detail", this.a.mAdapter.b(this.a.i), this.a.mAdapter.a());
    }
}
