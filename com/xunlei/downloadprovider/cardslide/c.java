package com.xunlei.downloadprovider.cardslide;

import com.xunlei.downloadprovider.member.payment.a.e.a;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: CardSlideActivity */
final class c implements a {
    final /* synthetic */ com.xunlei.downloadprovider.cardslide.c.a a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ CardSlideActivity c;

    c(CardSlideActivity cardSlideActivity, com.xunlei.downloadprovider.cardslide.c.a aVar, VideoUserInfo videoUserInfo) {
        this.c = cardSlideActivity;
        this.a = aVar;
        this.b = videoUserInfo;
    }

    public final void a() {
        u.a(this.a.c, this.b.getUid(), this.b.getKind(), true, "");
    }

    public final void a(String str) {
        u.a(this.a.c, this.b.getUid(), this.b.getKind(), false, str);
    }
}
