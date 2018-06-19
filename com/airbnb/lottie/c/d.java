package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: LottieValueAnimator */
final class d implements AnimatorUpdateListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.a.a) {
            this.a.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }
}
