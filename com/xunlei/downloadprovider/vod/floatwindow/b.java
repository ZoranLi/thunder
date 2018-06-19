package com.xunlei.downloadprovider.vod.floatwindow;

import com.xunlei.downloadprovider.vod.floatwindow.VodPlayerFloatWindowView.a;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;

/* compiled from: VodPlayerFloatWindow */
final class b implements a {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        if (this.a.g != null) {
            if (this.a.g.t()) {
                this.a.k = true;
                this.a.c();
                com.xunlei.downloadprovider.player.a.c("pause");
                return;
            }
            this.a.k = false;
            this.a.b();
            com.xunlei.downloadprovider.player.a.c("continue");
        }
    }

    public final void b() {
        a.v;
        a.a(this.a, this.a.b);
        com.xunlei.downloadprovider.player.a.c("close");
    }

    public final void c() {
        int n;
        boolean z;
        a.v;
        this.a.s = false;
        a.a(this.a, this.a.b);
        com.xunlei.downloadprovider.player.a.c("cancel_suspend");
        int i = 0;
        if (this.a.g != null) {
            boolean t = this.a.g.t();
            n = this.a.g.n();
            z = t;
            i = this.a.g.o();
        } else {
            z = false;
            n = z;
        }
        this.a.a(i, n);
        VodPlayerActivityNew.a(this.a.b, this.a.l, "float_window", this.a.n, z, n, this.a.p);
    }
}
