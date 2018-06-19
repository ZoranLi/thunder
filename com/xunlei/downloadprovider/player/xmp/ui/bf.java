package com.xunlei.downloadprovider.player.xmp.ui;

import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.xllib.b.j;

/* compiled from: PlayerOperationViewSlide */
final class bf extends aj {
    final /* synthetic */ PlayerOperationViewSlide a;

    bf(PlayerOperationViewSlide playerOperationViewSlide) {
        this.a = playerOperationViewSlide;
    }

    public final void b() {
        super.b();
        int c = this.a.e.f.c();
        if (c > 0) {
            this.a.b.setVisibility(8);
            this.a.b.setText(j.a((long) c));
        }
    }

    public final void a(BufferingState bufferingState, int i) {
        super.a(bufferingState, i);
        switch (bg.a[bufferingState.ordinal()]) {
            case 1:
                this.a.c.a();
                return;
            case 2:
                this.a.c.b();
                break;
            default:
                break;
        }
    }

    public final void a(String str) {
        super.a(str);
        this.a.c.b();
    }

    public final void a(int i) {
        super.a(i);
    }

    public final void h() {
        super.h();
        this.a.c.b();
        this.a.a.a();
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        if (i != 4) {
            PlayerOperationViewSlide.f(this.a);
        }
    }
}
