package com.xunlei.downloadprovider.cardslide;

import android.graphics.drawable.AnimationDrawable;

/* compiled from: CardSlideActivity */
final class i implements Runnable {
    final /* synthetic */ AnimationDrawable a;
    final /* synthetic */ CardSlideActivity b;

    i(CardSlideActivity cardSlideActivity, AnimationDrawable animationDrawable) {
        this.b = cardSlideActivity;
        this.a = animationDrawable;
    }

    public final void run() {
        this.b.o.setAlpha(0.0f);
        this.b.n.setAlpha(1.0f);
        this.b.l.setScaleX(1.0f);
        this.b.l.setScaleY(1.0f);
        this.a.stop();
    }
}
