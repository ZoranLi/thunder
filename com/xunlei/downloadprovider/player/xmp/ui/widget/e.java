package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

/* compiled from: PlayCompleteLikeGuideView */
public final class e extends AnimatorListenerAdapter {
    final /* synthetic */ PlayCompleteLikeGuideView a;

    public e(PlayCompleteLikeGuideView playCompleteLikeGuideView) {
        this.a = playCompleteLikeGuideView;
    }

    public final void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        if (this.a.b == 5) {
            ObjectAnimator.ofFloat(this.a.f, View.ALPHA, new float[]{1.0f}).setDuration(250).start();
        }
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.a.b = this.a.b - 1;
        if (this.a.b > null) {
            this.a.e.setText(String.valueOf(this.a.b));
        } else {
            PlayCompleteLikeGuideView.f(this.a);
        }
    }
}
