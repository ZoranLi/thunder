package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: TaskCommentItemViewHolder */
final class at implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ ar b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    at(ar arVar, Animation animation) {
        this.b = arVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.o.setEnabled(false);
        this.b.p.setEnabled(false);
        this.b.p.startAnimation(this.a);
    }
}
