package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: CommentItemViewHolder */
final class p implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ n b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    p(n nVar, Animation animation) {
        this.b = nVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.l.setEnabled(false);
        this.b.m.setEnabled(false);
        this.b.m.startAnimation(this.a);
    }
}
