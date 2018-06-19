package com.xunlei.downloadprovider.cardslide.slide;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;

/* compiled from: CardItemView */
final class c extends SimpleSpringListener {
    final /* synthetic */ CardItemView a;

    c(CardItemView cardItemView) {
        this.a = cardItemView;
    }

    public final void onSpringUpdate(Spring spring) {
        this.a.setScreenY((int) spring.getCurrentValue());
        this.a.g.a(this.a);
    }
}
