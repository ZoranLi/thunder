package com.xunlei.downloadprovider.cardslide;

import java.util.ArrayList;
import java.util.List;

/* compiled from: CardSlideActivity */
final class a implements com.xunlei.downloadprovider.cardslide.c.b.a {
    final /* synthetic */ CardSlideActivity a;

    a(CardSlideActivity cardSlideActivity) {
        this.a = cardSlideActivity;
    }

    public final void a(List<com.xunlei.downloadprovider.cardslide.c.a> list) {
        this.a.a = new ArrayList(list);
        this.a.v.sendEmptyMessage(1001);
    }

    public final void a() {
        this.a.v.sendEmptyMessage(1002);
    }
}
