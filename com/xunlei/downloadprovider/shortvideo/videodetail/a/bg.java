package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: TaskCommentItemViewHolderNew */
final class bg implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ be b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    bg(be beVar, Animation animation) {
        this.b = beVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.n.setEnabled(false);
        this.b.o.setEnabled(false);
        this.b.o.startAnimation(this.a);
    }
}
