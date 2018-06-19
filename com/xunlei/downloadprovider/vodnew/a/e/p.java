package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.vodnew.a.d.a.c;

/* compiled from: XLMediaPlayer */
final class p implements c {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void a(boolean z) {
        o.u;
        this.a.a.b((c) this);
        if (!z) {
            o.u;
            if (this.a.b()) {
                o.u;
                new StringBuilder("错误原因： ").append(this.a.b().e);
            }
            this.a.c(6);
            if (this.a.n) {
                this.a.n.a(this.a, 2, 0);
            }
        } else if (this.a.e.a()) {
            this.a.a.e();
            if (this.a.j) {
                this.a.j.a(this.a);
            }
        } else if (this.a.e.a()) {
            this.a.a.e();
            this.a.c(2);
        } else {
            o.u;
        }
    }
}
