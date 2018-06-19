package com.xunlei.downloadprovider.cardslide;

import com.xunlei.downloadprovider.e.a.f.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: CardSlideActivity */
final class b implements a {
    final /* synthetic */ BaseVideoInfo a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ CardSlideActivity c;

    b(CardSlideActivity cardSlideActivity, BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo) {
        this.c = cardSlideActivity;
        this.a = baseVideoInfo;
        this.b = videoUserInfo;
    }

    public final void a() {
        u.a(this.a.getVideoId(), this.b.getUid(), this.b.getKind(), true);
        CardSlideActivity.a(this.a.getVideoId());
    }

    public final void b() {
        u.a(this.a.getVideoId(), this.b.getUid(), this.b.getKind(), false);
    }
}
