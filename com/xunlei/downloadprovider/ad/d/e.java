package com.xunlei.downloadprovider.ad.d;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: AdBaseInfoViewHolder */
final class e implements AnimationListener {
    final /* synthetic */ a a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    e(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationEnd(Animation animation) {
        if (this.a.e.getVisibility() == null) {
            this.a.e.setVisibility(8);
        }
    }
}
