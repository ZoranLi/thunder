package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: LikeView */
final class e implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ LikeView b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    e(LikeView likeView, Animation animation) {
        this.b = likeView;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.b.startAnimation(this.a);
    }
}
