package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: WebsiteInfoViewHolder */
final class r implements AnimationListener {
    final /* synthetic */ o a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    r(o oVar) {
        this.a = oVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.e.getVisibility() == null) {
            this.a.e.setVisibility(8);
        }
    }
}
