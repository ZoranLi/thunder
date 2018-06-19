package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: CommentItemViewHolder */
final class q implements AnimationListener {
    final /* synthetic */ n a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    q(n nVar) {
        this.a = nVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.e.getVisibility() == null) {
            this.a.e.setVisibility(8);
        }
    }
}
