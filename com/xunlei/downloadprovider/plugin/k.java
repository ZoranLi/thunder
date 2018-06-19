package com.xunlei.downloadprovider.plugin;

/* compiled from: XLPluginDownloadManager */
final class k implements a$b {
    final /* synthetic */ a a;

    k(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        a.b(this.a).removeCallbacks(a.c(this.a));
        a.a(this.a, 100);
        a.b(this.a, 100);
        q.a().b(a.e(this.a));
        a.h(this.a);
    }

    public final void a(int i) {
        a.b(this.a).removeCallbacks(a.c(this.a));
        if (i == 6) {
            a.c(this.a, 6);
        } else {
            a.c(this.a, 5);
        }
    }
}
