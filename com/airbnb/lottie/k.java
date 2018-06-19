package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: LottieDrawable */
final class k implements AnimatorUpdateListener {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.a.m != null) {
            this.a.m.a(this.a.b.d);
        }
    }
}
