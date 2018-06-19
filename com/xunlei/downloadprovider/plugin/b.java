package com.xunlei.downloadprovider.plugin;

/* compiled from: XLPluginDownloadManager */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        a.a(this.a, a.a(this.a) + 1);
        if (a.a(this.a) < 100) {
            a.b(this.a, a.a(this.a));
            a.b(this.a).postDelayed(this, 1000);
            return;
        }
        a.b(this.a).removeCallbacks(a.c(this.a));
    }
}
