package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: FloatFragment */
final class k implements AnimationListener {
    final /* synthetic */ FloatFragment a;

    public final void onAnimationRepeat(Animation animation) {
    }

    k(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void onAnimationStart(Animation animation) {
        this.a.b.setVisibility(8);
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.b.setVisibility(0);
    }
}
