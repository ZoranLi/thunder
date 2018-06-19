package com.xunlei.downloadprovider.homepage.download;

/* compiled from: DownloadTabFragment */
final class ad implements Runnable {
    final /* synthetic */ d a;

    ad(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.b.isVisible()) {
            this.a.b.a = true;
            this.a.b.d();
        }
    }
}
