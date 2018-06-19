package com.xunlei.downloadprovider.cardslide;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: CardSlideActivity */
final class d implements a<Long> {
    final /* synthetic */ BaseVideoInfo a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ String c;
    final /* synthetic */ CardSlideActivity d;

    d(CardSlideActivity cardSlideActivity, BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, String str) {
        this.d = cardSlideActivity;
        this.a = baseVideoInfo;
        this.b = videoUserInfo;
        this.c = str;
    }

    public final void a(b bVar) {
        u.a(this.a.getVideoId(), this.a.getGcid(), this.b.getKind(), this.c);
    }

    public final /* synthetic */ void a(Object obj) {
        u.a(this.a.getVideoId(), this.a.getGcid(), this.b.getKind(), this.c);
    }
}
