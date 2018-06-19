package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: FeedItemShareLayout */
final class l implements AnimationListener {
    final /* synthetic */ FeedItemShareLayout a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    l(FeedItemShareLayout feedItemShareLayout) {
        this.a = feedItemShareLayout;
    }

    public final void onAnimationEnd(Animation animation) {
        FeedItemShareLayout.a(this.a);
    }
}
