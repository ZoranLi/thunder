package com.xunlei.downloadprovider.homepage.follow.ui;

import android.animation.ObjectAnimator;

/* compiled from: FollowTabFragment */
final class i implements Runnable {
    final /* synthetic */ FollowTabFragment a;

    i(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void run() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.h, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(1000);
        ofFloat.start();
        ofFloat.addListener(new j(this));
    }
}
