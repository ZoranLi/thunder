package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoArticleDetailActivity */
final class x implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    x(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.c() == null) {
            PhotoArticleDetailActivity.b(this.a, this.a.g);
        }
    }
}
