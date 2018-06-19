package com.xunlei.downloadprovider.xlui.recyclerview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: PullToRefreshHeaderView */
final class g implements AnimatorUpdateListener {
    final /* synthetic */ PullToRefreshHeaderView a;

    g(PullToRefreshHeaderView pullToRefreshHeaderView) {
        this.a = pullToRefreshHeaderView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        valueAnimator = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (valueAnimator < this.a.d && this.a.a()) {
            this.a.setContentGravity(48);
        }
        this.a.setVisibleHeight(valueAnimator);
    }
}
