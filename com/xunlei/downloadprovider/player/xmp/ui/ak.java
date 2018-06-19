package com.xunlei.downloadprovider.player.xmp.ui;

import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.xllib.b.j;

/* compiled from: PlayerOperationViewAuto */
final class ak extends aj {
    final /* synthetic */ PlayerOperationViewAuto a;

    ak(PlayerOperationViewAuto playerOperationViewAuto) {
        this.a = playerOperationViewAuto;
    }

    public final void b() {
        super.b();
        int c = this.a.e.f.c();
        if (c > 0) {
            this.a.b.setVisibility(0);
            this.a.b.setText(j.a((long) c));
        }
    }

    public final void a(BufferingState bufferingState, int i) {
        super.a(bufferingState, i);
        switch (al.a[bufferingState.ordinal()]) {
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
        int c = this.a.e.f.c();
        if (c > 0) {
            c -= i;
            if (c >= 0) {
                this.a.b.setText(j.a((long) c));
            }
        }
    }

    public final void h() {
        super.h();
        this.a.c.b();
        this.a.a.a();
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        if (i != 4) {
            PlayerOperationViewAuto.g(this.a);
        } else {
            PlayerOperationViewAuto.f(this.a);
        }
    }
}
