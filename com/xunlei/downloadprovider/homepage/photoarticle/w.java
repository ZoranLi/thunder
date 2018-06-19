package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoArticleDetailActivity */
final class w implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    w(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.c() == null) {
            PhotoArticleDetailActivity.b(this.a, this.a.getResources().getString(this.a.y));
            y.b("discuss_bar", this.a.f, this.a.h());
            this.a.o.a(null);
        }
    }
}
