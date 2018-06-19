package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: TaskCommentItemViewHolderNew */
final class bh implements AnimationListener {
    final /* synthetic */ be a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    bh(be beVar) {
        this.a = beVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.f.getVisibility() == null) {
            this.a.f.setVisibility(8);
        }
    }
}
