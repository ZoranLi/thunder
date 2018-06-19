package com.xunlei.downloadprovider.search.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: HintAnimEditText */
final class a implements AnimatorUpdateListener {
    final /* synthetic */ CharSequence a;
    final /* synthetic */ HintAnimEditText b;

    a(HintAnimEditText hintAnimEditText, CharSequence charSequence) {
        this.b = hintAnimEditText;
        this.a = charSequence;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.b.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (this.b.e < this.b.a) {
            this.b.b = this.a;
            this.b.e = this.b.e - (2.0f * this.b.a);
        }
        this.b.invalidate();
    }
}
