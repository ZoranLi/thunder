package com.xunlei.downloadprovider.ad.feedvideo;

import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: FeedVideoADItemView */
final class l extends aj {
    final /* synthetic */ ThunderXmpPlayer a;
    final /* synthetic */ h b;

    l(h hVar, ThunderXmpPlayer thunderXmpPlayer) {
        this.b = hVar;
        this.a = thunderXmpPlayer;
    }

    public final void a() {
        super.a();
        a.b().b.put(this.b.getMovieId(), Boolean.valueOf(true));
        this.b.a();
        this.b.h();
        this.a.a();
    }
}
