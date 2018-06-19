package com.xunlei.downloadprovider.contentpublish.website;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: WebsiteDetailFragment */
final class v implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ WebsiteDetailFragment b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    v(WebsiteDetailFragment websiteDetailFragment, Animation animation) {
        this.b = websiteDetailFragment;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.U.setSelected(true);
        this.b.U.startAnimation(this.a);
    }
}
