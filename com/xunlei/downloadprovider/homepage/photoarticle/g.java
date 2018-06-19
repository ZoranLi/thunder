package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.xllib.android.b;

/* compiled from: PhotoArticleDetailActivity */
final class g implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    g(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        this.a.n.dismiss();
        if (b.a(this.a) == null) {
            XLToast.showNoNetworkToast(this.a);
            return;
        }
        view = this.a.n.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.m.a(view.getId());
        y.a(this.a.f, this.a.h(), "delete", view.getId());
    }
}
