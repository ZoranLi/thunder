package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ShortMovieDetailFragment */
final class bg implements AnimationListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    bg(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.an.getVisibility() == null) {
            this.a.an.setVisibility(8);
        }
    }
}
