package com.xunlei.downloadprovider.search.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: HintAnimEditText */
final class b implements AnimatorListener {
    final /* synthetic */ CharSequence a;
    final /* synthetic */ HintAnimEditText b;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    b(HintAnimEditText hintAnimEditText, CharSequence charSequence) {
        this.b = hintAnimEditText;
        this.a = charSequence;
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.b = this.a;
    }
}
