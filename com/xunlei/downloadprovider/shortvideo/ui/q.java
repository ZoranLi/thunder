package com.xunlei.downloadprovider.shortvideo.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: PlayerUgcView */
public final class q implements AnimatorUpdateListener {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ a b;

    public q(a aVar, boolean[] zArr) {
        this.b = aVar;
        this.a = zArr;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (((float) valueAnimator.getCurrentPlayTime()) / 3500.0f > 0.9f && this.a[0] == null) {
            this.b.a(1, 0, 100);
            this.a[0] = 1;
        }
    }
}
