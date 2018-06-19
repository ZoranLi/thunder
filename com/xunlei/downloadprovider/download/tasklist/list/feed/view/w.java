package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.web.a;

/* compiled from: WebsiteViewHolder */
final class w implements OnClickListener {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    public final void onClick(View view) {
        a.a();
        a.a(this.a.getContext(), this.a.g.f, true, v.a(this.a.mAdapter.a()));
        b.a(this.a.f, "websize", this.a.mAdapter.b(this.a.i), this.a.mAdapter.a());
    }
}
