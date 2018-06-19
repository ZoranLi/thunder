package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoArticleDetailActivity */
final class v implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    v(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.c() == null) {
            view = this.a.j.a();
            int findLastVisibleItemPosition = this.a.k.findLastVisibleItemPosition();
            int headerViewsCount = this.a.i.getHeaderViewsCount();
            if (view < null) {
                if (findLastVisibleItemPosition >= this.a.j.getItemCount() + headerViewsCount) {
                    this.a.a(headerViewsCount);
                } else {
                    this.a.a();
                }
            } else if (findLastVisibleItemPosition >= view + headerViewsCount) {
                this.a.a(headerViewsCount);
            } else {
                this.a.a();
            }
        }
    }
}
