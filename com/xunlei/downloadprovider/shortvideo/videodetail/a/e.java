package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: BaseInfoViewHolder */
final class e implements AnimationListener {
    final /* synthetic */ c a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    e(c cVar) {
        this.a = cVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.c.getVisibility() == null) {
            this.a.c.setVisibility(8);
        }
    }
}
