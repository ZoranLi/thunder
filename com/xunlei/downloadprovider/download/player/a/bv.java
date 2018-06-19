package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.vod.speedplayback.VodSpeedRate;
import com.xunlei.downloadprovider.vod.speedplayback.a.a;
import com.xunlei.downloadprovider.vod.speedplayback.d;

/* compiled from: VipAccelerateTryController */
final class bv implements a {
    final /* synthetic */ bn a;

    bv(bn bnVar) {
        this.a = bnVar;
    }

    public final void a(VodSpeedRate vodSpeedRate) {
        if (this.a.f() != null) {
            this.a.f().a(104, String.valueOf(d.a(vodSpeedRate)));
        }
    }
}
