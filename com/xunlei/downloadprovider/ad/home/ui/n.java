package com.xunlei.downloadprovider.ad.home.ui;

import com.xunlei.downloadprovider.ad.common.adget.a.d;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: ADPlayVodItemBase */
final class n extends aj {
    final /* synthetic */ ThunderXmpPlayer a;
    final /* synthetic */ l b;

    n(l lVar, ThunderXmpPlayer thunderXmpPlayer) {
        this.b = lVar;
        this.a = thunderXmpPlayer;
    }

    public final void a() {
        super.a();
        if (this.b.c instanceof d) {
            ((d) this.b.c).b(BrothersApplication.getApplicationInstance());
        }
        this.a.f();
    }
}
