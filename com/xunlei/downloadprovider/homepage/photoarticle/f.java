package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.personal.user.ReportActivity;

/* compiled from: PhotoArticleDetailActivity */
final class f implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    f(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        view = this.a.n.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.n.dismiss();
        ReportActivity.a(this.a, 9, view.getId(), this.a.g.a, this.a.f, DispatchConstants.OTHER);
        y.a(this.a.f, this.a.h(), "jubao", view.getId());
    }
}
