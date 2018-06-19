package com.xunlei.downloadprovider.shortvideo.ui;

import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: PlayerUgcView */
final class g extends aj {
    final /* synthetic */ ThunderXmpPlayer a;
    final /* synthetic */ a b;

    g(a aVar, ThunderXmpPlayer thunderXmpPlayer) {
        this.b = aVar;
        this.a = thunderXmpPlayer;
    }

    public final void a() {
        super.a();
        this.b.a(this.a, this.b.c.getVideoId());
    }

    public final void a(int i) {
        super.a(i);
        this.b.a(this.a, i);
    }
}
