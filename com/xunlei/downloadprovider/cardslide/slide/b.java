package com.xunlei.downloadprovider.cardslide.slide;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;

/* compiled from: CardItemView */
final class b extends SimpleSpringListener {
    final /* synthetic */ CardItemView a;

    b(CardItemView cardItemView) {
        this.a = cardItemView;
    }

    public final void onSpringUpdate(Spring spring) {
        this.a.setScreenX((int) spring.getCurrentValue());
        this.a.g.a(this.a);
    }
}
