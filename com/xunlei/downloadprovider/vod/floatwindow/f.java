package com.xunlei.downloadprovider.vod.floatwindow;

/* compiled from: VodPlayerFloatWindow */
final class f implements Runnable {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.g != null) {
            this.a.f.a(this.a.g.n(), this.a.g.o(), this.a.g.p());
            this.a.w = this.a.w + 1;
            if (this.a.w % 5 == 4 && this.a.g.t()) {
                this.a.a(this.a.g.o(), this.a.g.n());
            }
        }
    }
}
