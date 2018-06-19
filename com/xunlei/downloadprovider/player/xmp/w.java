package com.xunlei.downloadprovider.player.xmp;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

/* compiled from: ThunderXmpPlayer */
final class w implements OnLayoutChangeListener {
    final /* synthetic */ ThunderXmpPlayer a;

    w(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.a.B != this.a.g.getWidth() || this.a.C != this.a.g.getHeight()) {
            this.a.B = this.a.g.getWidth();
            this.a.C = this.a.g.getHeight();
            ThunderXmpPlayer.a(this.a, this.a.B, this.a.C, this.a.j, this.a.k);
        }
    }
}
