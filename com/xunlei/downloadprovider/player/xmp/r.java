package com.xunlei.downloadprovider.player.xmp;

/* compiled from: ThunderXmpPlayer */
final class r extends a {
    final /* synthetic */ y a;
    final /* synthetic */ ThunderXmpPlayer b;

    r(ThunderXmpPlayer thunderXmpPlayer, y yVar) {
        this.b = thunderXmpPlayer;
        this.a = yVar;
    }

    public final void b() {
        super.b();
        this.b.b();
        if (this.b.s != null) {
            this.b.s.b();
        }
    }

    public final void a() {
        super.a();
        this.b.l.b(this.a);
        if (this.b.f.a.getState() == 0) {
            this.b.b(this.a);
        } else {
            this.b.F = true;
            this.b.b();
        }
        if (this.b.s != null) {
            this.b.s.a();
        }
    }
}
