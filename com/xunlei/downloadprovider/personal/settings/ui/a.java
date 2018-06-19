package com.xunlei.downloadprovider.personal.settings.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: ChartView */
final class a implements AnimatorUpdateListener {
    final /* synthetic */ ChartView a;

    a(ChartView chartView) {
        this.a = chartView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.w = ((Number) valueAnimator.getAnimatedValue("angle")).floatValue();
        ChartView.d;
        new StringBuilder("onAnimationUpdate angle=").append(this.a.w);
        this.a.invalidate();
    }
}
