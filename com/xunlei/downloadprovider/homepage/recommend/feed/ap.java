package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: FeedVideoItemView */
final class ap implements AnimationListener {
    final /* synthetic */ z a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    ap(z zVar) {
        this.a = zVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.q.dismiss();
    }
}
