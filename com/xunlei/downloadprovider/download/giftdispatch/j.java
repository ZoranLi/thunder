package com.xunlei.downloadprovider.download.giftdispatch;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;

/* compiled from: GiftDispatchingActivity */
final class j implements AnimatorListener {
    final /* synthetic */ GiftDispatchingActivity a;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    j(GiftDispatchingActivity giftDispatchingActivity) {
        this.a = giftDispatchingActivity;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.n.setVisibility(0);
        animator = ObjectAnimator.ofFloat(this.a.n, "scaleX", new float[]{1.0f, 1.3f, 1.0f}).setDuration(300);
        Animator duration = ObjectAnimator.ofFloat(this.a.n, "scaleY", new float[]{1.0f, 1.3f, 1.0f}).setDuration(300);
        Animator duration2 = ObjectAnimator.ofFloat(this.a.n, "alpha", new float[]{0.8f, 1.0f, 0.8f}).setDuration(300);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator).with(duration).with(duration2);
        animatorSet.start();
        this.a.e.removeView(this.a.d);
        new Handler().postDelayed(new g(this.a), 800);
    }
}
