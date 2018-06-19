package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ShortMovieDetailFragment */
final class ao implements AnimatorListener {
    final /* synthetic */ am a;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    public final void onAnimationStart(Animator animator) {
    }

    ao(am amVar) {
        this.a = amVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a.aF.setVisibility(8);
        this.a.a.a(0);
    }
}
