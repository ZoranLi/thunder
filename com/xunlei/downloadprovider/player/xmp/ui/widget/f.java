package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: PlayCompleteLikeGuideView */
final class f implements AnimatorUpdateListener {
    final /* synthetic */ PlayCompleteLikeGuideView a;

    f(PlayCompleteLikeGuideView playCompleteLikeGuideView) {
        this.a = playCompleteLikeGuideView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.g.setProgress((long) ((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
