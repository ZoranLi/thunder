package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DoubleClickAnimationView */
final class b implements AnimationListener {
    final /* synthetic */ a a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    b(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.b.a.setImageDrawable(null);
        this.a.b.b.setImageDrawable(null);
        this.a.b.setBackgroundColor(0);
        this.a.b.setAlpha(1.0f);
        this.a.b.c = false;
        this.a.a.a();
    }
}
