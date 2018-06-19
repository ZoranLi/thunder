package com.xunlei.downloadprovider.ad.splash.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: SplashAdView */
final class g implements AnimatorUpdateListener {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.h.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
