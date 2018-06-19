package com.xunlei.downloadprovider.player.xmp.ui;

import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: PlayerOperationViewDetail */
final class av extends aj {
    final /* synthetic */ PlayerOperationViewDetail a;

    av(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void b() {
        super.b();
        this.a.d();
    }

    public final void a(int i, boolean z) {
        super.a(i, z);
        this.a.a(i, z);
    }

    public final void a() {
        super.a();
        PlayerOperationViewDetail.j(this.a);
    }

    public final void a(int i) {
        super.a(i);
        this.a.a(i);
    }

    public final void g() {
        super.g();
        this.a.a(this.a.a.h());
    }

    public final void a(BufferingState bufferingState, int i) {
        super.a(bufferingState, i);
        switch (aw.a[bufferingState.ordinal()]) {
            case 1:
                this.a.b();
                return;
            case 2:
                this.a.g();
                break;
            default:
                break;
        }
    }

    public final void h() {
        super.h();
        this.a.A.removeMessages(3);
        this.a.x.setVisibility(8);
        PlayerOperationViewDetail.b(this.a);
        this.a.g();
    }

    public final void a(String str) {
        super.a(str);
        PlayerOperationViewDetail.n(this.a);
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
                PlayerOperationViewDetail.q(this.a);
                return;
            case 1:
                PlayerOperationViewDetail.r(this.a);
                break;
            case 3:
                PlayerOperationViewDetail.p(this.a);
                return;
            case 4:
                PlayerOperationViewDetail.o(this.a);
                return;
            default:
                break;
        }
    }
}
