package com.xunlei.downloadprovider.player.xmp.ui;

import com.xunlei.downloadprovider.player.xmp.ui.PlayerGestureViewDefault.a;

/* compiled from: PlayerControlDetail */
final class v implements a {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final boolean a() {
        PlayerOperationViewDetail playerOperationViewDetail = this.a.f;
        if (playerOperationViewDetail.b) {
            playerOperationViewDetail.b(true);
        } else {
            playerOperationViewDetail.a(true);
            if (playerOperationViewDetail.a.l()) {
                playerOperationViewDetail.a();
            }
        }
        if (this.a.c != null) {
            return this.a.c.onClick();
        }
        return true;
    }

    public final void b() {
        this.a.f.b(false);
    }

    public final void c() {
        this.a.f.b(false);
    }

    public final void d() {
        this.a.f.b(false);
    }

    public final boolean e() {
        return this.a.d != null ? this.a.d.a() : false;
    }

    public final void f() {
        if (this.a.e != null) {
            this.a.e.a();
        }
    }
}
