package com.xunlei.downloadprovider.player.xmp;

import com.xunlei.downloadprovider.player.xmp.ui.widget.PlayCompleteLikeGuideView.a;

/* compiled from: ThunderXmpPlayer */
public final class v implements a {
    final /* synthetic */ ThunderXmpPlayer a;

    public v(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public final void onClick(int i) {
        ThunderXmpPlayer.c(this.a);
        if (this.a.x != null) {
            this.a.x.onClick(i);
        }
    }

    public final void a(boolean z) {
        if (this.a.x != null) {
            this.a.x.a(z);
        }
    }
}
