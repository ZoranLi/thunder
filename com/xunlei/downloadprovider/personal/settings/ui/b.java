package com.xunlei.downloadprovider.personal.settings.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.xunlei.download.Downloads.Impl.RequestHeaders;

/* compiled from: ChartView */
final class b implements AnimatorUpdateListener {
    final /* synthetic */ ChartView a;

    b(ChartView chartView) {
        this.a = chartView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.y = ((Integer) valueAnimator.getAnimatedValue(RequestHeaders.COLUMN_VALUE)).intValue();
        this.a.z = ((float) this.a.y) / 100.0f;
        this.a.invalidate();
    }
}
