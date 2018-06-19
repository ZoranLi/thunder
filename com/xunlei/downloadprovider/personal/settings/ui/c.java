package com.xunlei.downloadprovider.personal.settings.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ChartView */
final class c implements AnimatorListener {
    final /* synthetic */ ChartView a;

    public final void onAnimationEnd(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    c(ChartView chartView) {
        this.a = chartView;
    }

    public final void onAnimationCancel(Animator animator) {
        this.a.x = false;
        this.a.a.start();
    }
}
