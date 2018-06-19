package com.xunlei.downloadprovider.vod.speeduptrial;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: BubbleBarView */
final class b implements AnimatorUpdateListener {
    final /* synthetic */ BubbleBarView a;

    b(BubbleBarView bubbleBarView) {
        this.a = bubbleBarView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b = (int) ((((float) (BubbleBarView.o - this.a.v)) * ((Float) valueAnimator.getAnimatedValue()).floatValue()) + ((float) this.a.v));
        this.a.requestLayout();
    }
}
