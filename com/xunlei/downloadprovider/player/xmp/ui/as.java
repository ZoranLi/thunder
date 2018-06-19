package com.xunlei.downloadprovider.player.xmp.ui;

import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.xllib.b.j;

/* compiled from: PlayerOperationViewDefault */
final class as extends aj {
    final /* synthetic */ PlayerOperationViewDefault a;

    as(PlayerOperationViewDefault playerOperationViewDefault) {
        this.a = playerOperationViewDefault;
    }

    public final void a(int i, boolean z) {
        super.a(i, z);
        PlayerOperationViewDefault playerOperationViewDefault = this.a;
        if (z) {
            i = playerOperationViewDefault.a.f.c();
        }
        playerOperationViewDefault.m.setSecondaryProgress(i);
        playerOperationViewDefault.g.setSecondaryProgress(i);
    }

    public final void a(int i) {
        super.a(i);
        PlayerOperationViewDefault playerOperationViewDefault = this.a;
        if (i >= 0) {
            playerOperationViewDefault.m.setProgress(i);
            playerOperationViewDefault.g.setProgress(i);
            playerOperationViewDefault.i.setText(j.a((long) i));
        }
    }

    public final void a() {
        super.a();
        PlayerOperationViewDefault.d(this.a);
    }

    public final void a(BufferingState bufferingState, int i) {
        super.a(bufferingState, i);
        switch (at.a[bufferingState.ordinal()]) {
            case 1:
                PlayerOperationViewDefault.e(this.a);
                return;
            case 2:
                this.a.i();
                break;
            default:
                break;
        }
    }

    public final void a(String str) {
        super.a(str);
        PlayerOperationViewDefault.g(this.a);
    }

    public final void b() {
        super.b();
        this.a.h();
    }

    public final void h() {
        super.h();
        this.a.k.a();
        this.a.i();
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        StringBuilder stringBuilder = new StringBuilder("onStateChange() currentState=");
        stringBuilder.append(i);
        stringBuilder.append(" preState=");
        stringBuilder.append(i2);
        this.a.setSeekBarStatus(i);
        switch (i) {
            case 0:
                PlayerOperationViewDefault.m(this.a);
                return;
            case 1:
                PlayerOperationViewDefault.n(this.a);
                break;
            case 3:
                PlayerOperationViewDefault.l(this.a);
                return;
            case 4:
                PlayerOperationViewDefault.k(this.a);
                return;
            default:
                break;
        }
    }
}
