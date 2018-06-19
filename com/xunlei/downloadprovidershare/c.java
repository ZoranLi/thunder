package com.xunlei.downloadprovidershare;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovidershare.a.f;

/* compiled from: InternalShareHelper */
final class c implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ f b;
    final /* synthetic */ b c;

    c(b bVar, boolean z, f fVar) {
        this.c = bVar;
        this.a = z;
        this.b = fVar;
    }

    public final void run() {
        b.a(this.c.c);
        if (this.c.c.a()) {
            this.c.c.c();
        } else if (this.a) {
            this.c.c.b().a(this.c.a, this.c.b, this.b, this.c.c.f);
        } else {
            XLToast.showToast(this.c.a, "网络不给力");
            this.c.c.c();
        }
    }
}
