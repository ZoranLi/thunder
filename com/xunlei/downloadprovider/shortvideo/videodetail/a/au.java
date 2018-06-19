package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: TaskCommentItemViewHolder */
final class au implements AnimationListener {
    final /* synthetic */ ar a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    au(ar arVar) {
        this.a = arVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.e.getVisibility() == null) {
            this.a.e.setVisibility(8);
        }
    }
}
