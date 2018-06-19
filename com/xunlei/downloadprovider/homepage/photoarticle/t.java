package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoArticleDetailActivity */
final class t implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    t(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
