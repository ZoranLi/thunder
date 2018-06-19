package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: LikeView */
final class f implements AnimationListener {
    final /* synthetic */ LikeView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    f(LikeView likeView) {
        this.a = likeView;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.a.setVisibility(8);
    }
}
