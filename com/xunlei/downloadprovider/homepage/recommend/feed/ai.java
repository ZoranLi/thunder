package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: FeedVideoItemView */
final class ai implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ z b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    ai(z zVar, Animation animation) {
        this.b = zVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.n.getLikeImageView().startAnimation(this.a);
    }
}
