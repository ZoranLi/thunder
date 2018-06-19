package com.xunlei.downloadprovider.cardslide;

import com.xunlei.downloadprovider.cardslide.c.a;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: CardSlideActivity */
final class t extends c {
    final /* synthetic */ a a;
    final /* synthetic */ CardSlideActivity b;

    t(CardSlideActivity cardSlideActivity, a aVar) {
        this.b = cardSlideActivity;
        this.a = aVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        obj = new StringBuilder("onLoginCompleted = ");
        obj.append(z);
        obj.append(", ");
        obj.append(i);
        if (z && this.a) {
            this.b.a(this.a);
            this.b.b((a) this.a);
            this.b.c((a) this.a);
        }
    }
}
