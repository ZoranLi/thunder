package com.xunlei.downloadprovider.homepage.photoarticle;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: PhotoArticleDetailActivity */
final class j implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    j(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            if (this.a.g != null) {
                if (this.a.h != null) {
                    if (this.a.j != null) {
                        view = this.a.j;
                        if (view.g != null) {
                            view = view.g;
                            if (!TextUtils.isEmpty(view.b)) {
                                view.a.loadUrl(view.b);
                            }
                        }
                    }
                    return;
                }
            }
            this.a.a(this.a.f);
        }
    }
}
