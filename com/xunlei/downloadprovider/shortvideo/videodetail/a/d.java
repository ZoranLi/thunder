package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: BaseInfoViewHolder */
final class d implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ c b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    d(c cVar, Animation animation) {
        this.b = cVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.a.setSelected(true);
        this.b.a.startAnimation(this.a);
    }
}
