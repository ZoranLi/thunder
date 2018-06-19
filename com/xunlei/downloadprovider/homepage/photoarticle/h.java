package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PhotoArticleDetailActivity */
final class h implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    h(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        this.a.n.dismiss();
        view = this.a.n.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        y.a(this.a.f, this.a.h(), "cancel", view.getId());
    }
}
