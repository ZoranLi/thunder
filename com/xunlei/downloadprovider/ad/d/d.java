package com.xunlei.downloadprovider.ad.d;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: AdBaseInfoViewHolder */
final class d implements AnimationListener {
    final /* synthetic */ Animation a;
    final /* synthetic */ a b;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    d(a aVar, Animation animation) {
        this.b = aVar;
        this.a = animation;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.d.setSelected(true);
        this.b.d.startAnimation(this.a);
    }
}
