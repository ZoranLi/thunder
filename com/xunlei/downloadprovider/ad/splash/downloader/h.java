package com.xunlei.downloadprovider.ad.splash.downloader;

/* compiled from: DownloadRequestQueue */
final class h implements Runnable {
    final /* synthetic */ DownloadRequest a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ int d;
    final /* synthetic */ a e;

    h(a aVar, DownloadRequest downloadRequest, long j, long j2, int i) {
        this.e = aVar;
        this.a = downloadRequest;
        this.b = j;
        this.c = j2;
        this.d = i;
    }

    public final void run() {
        if (this.a.i != null) {
            this.a.i.a(this.d);
        }
    }
}
