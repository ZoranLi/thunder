package com.xunlei.downloadprovider.homepage.follow.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: FollowTabFragment */
final class j extends AnimatorListenerAdapter {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onAnimationEnd(Animator animator) {
        this.a.a.h.setVisibility(8);
    }
}
