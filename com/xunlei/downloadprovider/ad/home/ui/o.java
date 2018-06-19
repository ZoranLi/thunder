package com.xunlei.downloadprovider.ad.home.ui;

import com.xunlei.downloadprovider.ad.common.adget.a.d;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.b;

/* compiled from: ADPlayVodItemBase */
final class o implements b {
    final /* synthetic */ ThunderXmpPlayer a;
    final /* synthetic */ l b;

    public final void b() {
    }

    o(l lVar, ThunderXmpPlayer thunderXmpPlayer) {
        this.b = lVar;
        this.a = thunderXmpPlayer;
    }

    public final void a() {
        if (this.b.c instanceof d) {
            ((d) this.b.c).a(BrothersApplication.getApplicationInstance(), this.a.f.a.getPosition());
        }
    }
}
