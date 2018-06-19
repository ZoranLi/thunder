package com.xunlei.downloadprovider.xlui.recyclerview;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: XRecyclerView */
final class k implements AnimatorUpdateListener {
    final /* synthetic */ IntEvaluator a;
    final /* synthetic */ int b;
    final /* synthetic */ XRecyclerView c;

    k(XRecyclerView xRecyclerView, IntEvaluator intEvaluator, int i) {
        this.c = xRecyclerView;
        this.a = intEvaluator;
        this.b = i;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        valueAnimator = this.a.evaluate(0.01f, Integer.valueOf(((Integer) valueAnimator.getAnimatedValue()).intValue()), Integer.valueOf(this.b)).intValue();
        this.c.d.setVisibleHeight(valueAnimator);
        if (valueAnimator == this.b) {
            this.c.b = true;
            this.c.d.setState(2);
            this.c.a();
            this.c.f.onChanged();
            this.c.c();
        }
    }
}
