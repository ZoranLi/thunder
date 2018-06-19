package com.xunlei.downloadprovider.download.center;

/* compiled from: DownloadCenterActivityFragment */
final class ah implements Runnable {
    final /* synthetic */ b a;

    ah(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.b.isVisible()) {
            this.a.b.q = true;
            this.a.b.e(false);
        }
    }
}
