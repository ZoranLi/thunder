package com.xunlei.downloadprovider.ad.splash.downloader;

/* compiled from: DownloadRequestQueue */
final class f implements Runnable {
    final /* synthetic */ DownloadRequest a;
    final /* synthetic */ a b;

    f(a aVar, DownloadRequest downloadRequest) {
        this.b = aVar;
        this.a = downloadRequest;
    }

    public final void run() {
        if (this.a.i != null) {
            this.a.i.a();
        }
    }
}
