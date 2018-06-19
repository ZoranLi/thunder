package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* compiled from: DoubleClickAnimationView */
public final class a implements Runnable {
    final /* synthetic */ com.xunlei.downloadprovider.player.xmp.ui.widget.DoubleClickAnimationView.a a;
    final /* synthetic */ DoubleClickAnimationView b;

    public a(DoubleClickAnimationView doubleClickAnimationView, com.xunlei.downloadprovider.player.xmp.ui.widget.DoubleClickAnimationView.a aVar) {
        this.b = doubleClickAnimationView;
        this.a = aVar;
    }

    public final void run() {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setAnimationListener(new b(this));
        this.b.startAnimation(alphaAnimation);
    }
}
