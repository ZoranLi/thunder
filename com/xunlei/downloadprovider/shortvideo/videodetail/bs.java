package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: ShortMovieDetailFragment */
final class bs implements AnimatorListener {
    final /* synthetic */ boolean a;
    final /* synthetic */ ShortMovieDetailFragment b;

    public final void onAnimationCancel(Animator animator) {
    }

    public final void onAnimationRepeat(Animator animator) {
    }

    bs(ShortMovieDetailFragment shortMovieDetailFragment, boolean z) {
        this.b = shortMovieDetailFragment;
        this.a = z;
    }

    public final void onAnimationStart(Animator animator) {
        this.b.aA.setVisibility(0);
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.aA.setVisibility(this.a ? 0 : 4);
    }
}
