package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.homepage.photoarticle.PhotoArticleDetailActivity;

/* compiled from: PhotoArticleViewHolder */
final class j implements OnClickListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        PhotoArticleDetailActivity.a(this.a.getContext(), i.b(this.a.mAdapter.a()), this.a.d.a, this.a.d.b, false);
        b.b(this.a.d, i.b(this.a.mAdapter.a()), this.a.mAdapter.b(this.a.c), this.a.mAdapter.a());
    }
}
