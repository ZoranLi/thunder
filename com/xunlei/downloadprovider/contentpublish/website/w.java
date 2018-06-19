package com.xunlei.downloadprovider.contentpublish.website;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: WebsiteDetailFragment */
final class w implements AnimationListener {
    final /* synthetic */ WebsiteDetailFragment a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    w(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.V.getVisibility() == null) {
            this.a.V.setVisibility(8);
        }
    }
}
