package com.xunlei.downloadprovider.homepage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: HomeFragmentAnimatorHelper */
final class n extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ m b;

    n(m mVar, boolean z) {
        this.b = mVar;
        this.a = z;
    }

    public final void onAnimationStart(Animator animator) {
        new StringBuilder("Start---isDown=").append(this.a);
        this.b.b = true;
    }

    public final void onAnimationEnd(Animator animator) {
        new StringBuilder("End---isDown=").append(this.a);
        this.b.b = false;
    }
}
