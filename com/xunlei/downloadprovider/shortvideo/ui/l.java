package com.xunlei.downloadprovider.shortvideo.ui;

import com.xunlei.downloadprovider.player.xmp.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: PlayerUgcView */
final class l extends a {
    final /* synthetic */ BaseVideoInfo a;
    final /* synthetic */ VideoUserInfo b;
    final /* synthetic */ boolean c;
    final /* synthetic */ boolean d;
    final /* synthetic */ a e;

    l(a aVar, BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, boolean z2) {
        this.e = aVar;
        this.a = baseVideoInfo;
        this.b = videoUserInfo;
        this.c = z;
        this.d = z2;
    }

    public final void a() {
        super.a();
        this.e.b(this.a, this.b, this.c, this.d);
    }
}
