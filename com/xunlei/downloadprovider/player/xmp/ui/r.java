package com.xunlei.downloadprovider.player.xmp.ui;

import com.xunlei.downloadprovider.player.xmp.ui.PlayerGestureViewDefault.a;

/* compiled from: PlayerControlDefault */
final class r implements a {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final boolean a() {
        PlayerOperationViewDefault playerOperationViewDefault = this.a.f;
        if (playerOperationViewDefault.a != null) {
            if (playerOperationViewDefault.b) {
                playerOperationViewDefault.c();
            } else {
                if (playerOperationViewDefault.a != null) {
                    new StringBuilder("show--isShowing=").append(playerOperationViewDefault.b);
                    playerOperationViewDefault.a();
                    playerOperationViewDefault.c.setVisibility(0);
                    playerOperationViewDefault.f.setVisibility(0);
                    if (!playerOperationViewDefault.a.f.f) {
                        playerOperationViewDefault.l.setVisibility(0);
                    }
                    playerOperationViewDefault.m.setVisibility(8);
                    playerOperationViewDefault.f();
                    playerOperationViewDefault.b = true;
                    if (playerOperationViewDefault.n != null) {
                        playerOperationViewDefault.n.a(true);
                    }
                }
                if (playerOperationViewDefault.a.l()) {
                    playerOperationViewDefault.b();
                }
            }
        }
        if (this.a.c != null) {
            return this.a.c.onClick();
        }
        return true;
    }

    public final void b() {
        this.a.f.c();
    }

    public final void c() {
        this.a.f.c();
    }

    public final void d() {
        this.a.f.c();
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
