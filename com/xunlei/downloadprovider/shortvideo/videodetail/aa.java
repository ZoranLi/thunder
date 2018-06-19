package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: ShortMovieDetailActivity */
final class aa implements AnimatorListener {
    final /* synthetic */ int a;
    final /* synthetic */ MarginLayoutParams b;
    final /* synthetic */ ShortMovieDetailActivity c;

    public final void onAnimationRepeat(Animator animator) {
    }

    aa(ShortMovieDetailActivity shortMovieDetailActivity, int i, MarginLayoutParams marginLayoutParams) {
        this.c = shortMovieDetailActivity;
        this.a = i;
        this.b = marginLayoutParams;
    }

    public final void onAnimationStart(Animator animator) {
        if (this.c.isFinishing() == null && this.a == null) {
            this.c.T.setVisibility(8);
        }
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.c.isFinishing() == null) {
            if (this.a == null) {
                this.c.d(true);
                this.c.a(this.c, this.c.r);
            } else {
                this.c.d(false);
            }
            this.c.a(this.b);
            this.c.h();
            this.c.k.a();
        }
    }

    public final void onAnimationCancel(Animator animator) {
        if (this.c.isFinishing() == null) {
            if (this.a == null) {
                this.c.d(true);
                this.c.a(this.c, this.c.r);
            } else {
                this.c.d(false);
            }
            this.c.k.a();
        }
    }
}
