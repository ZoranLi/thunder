package com.xunlei.downloadprovider.shortvideo.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: PlayerUgcView */
public final class c implements AnimatorListener {
    final /* synthetic */ a a;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    public c(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.b.G.c();
        this.a.b.G.setVisibility(8);
        this.a.b.s.setText("领红包");
        this.a.a(0, 1, 500);
        this.a.b.E.setVisibility(0);
        this.a.b.E.a();
    }
}
