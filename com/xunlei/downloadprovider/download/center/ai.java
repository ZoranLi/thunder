package com.xunlei.downloadprovider.download.center;

/* compiled from: DownloadCenterActivityFragment */
final class ai implements Runnable {
    final /* synthetic */ b a;

    ai(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.b.isVisible()) {
            this.a.b.f();
            this.a.b.e(false);
            this.a.b.q = true;
            return;
        }
        this.a.b.q = true;
    }
}
