package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ShortMovieDetailFragment */
final class an implements AnimatorListener {
    final /* synthetic */ am a;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationEnd(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    an(am amVar) {
        this.a = amVar;
    }

    public final void onAnimationRepeat(Animator animator) {
        this.a.a.aE = this.a.a.aE + 1;
        if (this.a.a.aE == 3) {
            this.a.a.aG.c();
            this.a.a.aG.setVisibility(8);
            this.a.a.aF.setVisibility(0);
            this.a.a.aF.a();
        }
    }
}
