package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: WebsiteInfoViewHolder */
final class q implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ o b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    q(o oVar, Animation animation) {
        this.b = oVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.c.setSelected(true);
        this.b.c.startAnimation(this.a);
    }
}
