package com.xunlei.downloadprovider.homepage.download;

/* compiled from: DownloadTabFragment */
final class ac implements Runnable {
    final /* synthetic */ d a;

    ac(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.b.isVisible()) {
            this.a.b.a();
            this.a.b.a = true;
            return;
        }
        this.a.b.a = true;
    }
}
