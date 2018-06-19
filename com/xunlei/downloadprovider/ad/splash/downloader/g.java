package com.xunlei.downloadprovider.ad.splash.downloader;

/* compiled from: DownloadRequestQueue */
final class g implements Runnable {
    final /* synthetic */ DownloadRequest a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;

    g(a aVar, DownloadRequest downloadRequest, int i, String str) {
        this.d = aVar;
        this.a = downloadRequest;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        if (this.a.i != null) {
            this.a.i.b();
        }
    }
}
