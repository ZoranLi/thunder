package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: ShortMovieDetailFragment */
final class bf implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ ShortMovieDetailFragment b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    bf(ShortMovieDetailFragment shortMovieDetailFragment, Animation animation) {
        this.b = shortMovieDetailFragment;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.am.setSelected(true);
        this.b.am.startAnimation(this.a);
    }
}
