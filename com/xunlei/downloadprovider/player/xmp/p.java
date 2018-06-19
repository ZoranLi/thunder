package com.xunlei.downloadprovider.player.xmp;

import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.a;

/* compiled from: ThunderXmpPlayer */
final class p implements a {
    final /* synthetic */ ThunderXmpPlayer a;

    p(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public final boolean a() {
        if (this.a.t != null) {
            this.a.t.a();
        }
        if (this.a.v) {
            this.a.b(true);
            ThunderXmpPlayer.c(this.a);
        }
        return true;
    }
}
