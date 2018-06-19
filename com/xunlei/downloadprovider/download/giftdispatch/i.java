package com.xunlei.downloadprovider.download.giftdispatch;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;

/* compiled from: GiftDispatchingActivity */
final class i implements AnimatorListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ GiftDispatchingActivity c;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    i(GiftDispatchingActivity giftDispatchingActivity, int i, int i2) {
        this.c = giftDispatchingActivity;
        this.a = i;
        this.b = i2;
    }

    public final void onAnimationStart(Animator animator) {
        GiftDispatchingActivity.i(this.c);
        GiftDispatchingActivity.j(this.c);
    }

    public final void onAnimationEnd(Animator animator) {
        this.c.f.setVisibility(0);
        animator = ObjectAnimator.ofFloat(this.c.f, "translationY", new float[]{0.0f, -20.0f, 0.0f, 20.0f, 0.0f, 5.0f, 0.0f}).setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator);
        animatorSet.start();
        GiftDispatchingActivity.a(this.c.d, this.a, this.b - 50);
    }
}
