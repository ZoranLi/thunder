package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: PlayerPosterView */
final class bh implements AnimationListener {
    final /* synthetic */ PlayerPosterView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    bh(PlayerPosterView playerPosterView) {
        this.a = playerPosterView;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.setVisibility(8);
    }
}
