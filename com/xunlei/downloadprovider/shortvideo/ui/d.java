package com.xunlei.downloadprovider.shortvideo.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: PlayerUgcView */
public final class d implements AnimatorListener {
    final /* synthetic */ a a;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    public d(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.b.E.setVisibility(8);
        this.a.b.F.setVisibility(0);
    }
}
