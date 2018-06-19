package com.xunlei.downloadprovider.shortvideo.ui;

import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ui.widget.PlayCompleteLikeGuideView.a;

/* compiled from: PlayerUgcView */
final class h implements a {
    final /* synthetic */ ThunderXmpPlayer a;
    final /* synthetic */ a b;

    h(a aVar, ThunderXmpPlayer thunderXmpPlayer) {
        this.b = aVar;
        this.a = thunderXmpPlayer;
    }

    public final void onClick(int i) {
        if (this.b.p() != 0) {
            this.b.d.a("video_end");
        }
    }

    public final void a(boolean z) {
        this.a.f();
    }
}
