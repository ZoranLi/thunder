package com.xunlei.downloadprovider.homepage.photoarticle;

import com.xunlei.downloadprovider.homepage.photoarticle.b.b.a;
import com.xunlei.xllib.android.b;

/* compiled from: PhotoArticleDetailActivity */
final class k implements a {
    final /* synthetic */ PhotoArticleDetailActivity a;

    k(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void a() {
        this.a.g();
        this.a.u.setVisibility(8);
        this.a.v.hide();
    }

    public final void a(int i) {
        if (!b.a(this.a)) {
            this.a.u.setErrorType(2);
        } else if (i == 404) {
            this.a.u.setErrorType(1);
        }
        PhotoArticleDetailActivity.b(this.a);
    }
}
