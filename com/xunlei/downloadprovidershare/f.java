package com.xunlei.downloadprovidershare;

import com.xunlei.common.commonview.XLToast;

/* compiled from: InternalShareHelper */
final class f implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ com.xunlei.downloadprovidershare.a.f b;
    final /* synthetic */ e c;

    f(e eVar, boolean z, com.xunlei.downloadprovidershare.a.f fVar) {
        this.c = eVar;
        this.a = z;
        this.b = fVar;
    }

    public final void run() {
        b.a(this.c.b.a);
        if (!this.c.b.a.a()) {
            if (!this.a && this.c.a == ShareOperationType.THUNDER_COMMAND) {
                XLToast.showToast(this.c.b.a.a, "生成迅雷口令失败");
                this.c.b.a.c();
            } else if (this.a) {
                if (this.c.b.a.d != null) {
                    this.c.b.a.d.onShareTargetClicked(this.c.a, this.c.b.a.c);
                }
                b.a(this.c.b.a, this.c.a, this.b);
            } else {
                XLToast.showToast(this.c.b.a.a, "网络不给力");
                this.c.b.a.c();
            }
        }
    }
}
