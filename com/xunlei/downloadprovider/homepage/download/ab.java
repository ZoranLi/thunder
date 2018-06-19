package com.xunlei.downloadprovider.homepage.download;

/* compiled from: DownloadTabFragment */
final class ab implements Runnable {
    final /* synthetic */ d a;

    ab(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.b.isVisible()) {
            this.a.b.a = true;
        }
    }
}
