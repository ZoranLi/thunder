package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: PlayCompleteLikeGuideView */
final class g extends AnimatorListenerAdapter {
    final /* synthetic */ PlayCompleteLikeGuideView a;

    g(PlayCompleteLikeGuideView playCompleteLikeGuideView) {
        this.a = playCompleteLikeGuideView;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.a(false);
    }
}
