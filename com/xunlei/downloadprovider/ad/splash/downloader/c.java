package com.xunlei.downloadprovider.ad.splash.downloader;

import java.util.TimerTask;

/* compiled from: DownloadDispatcher */
final class c extends TimerTask {
    final /* synthetic */ DownloadRequest a;
    final /* synthetic */ b b;

    c(b bVar, DownloadRequest downloadRequest) {
        this.b = bVar;
        this.a = downloadRequest;
    }

    public final void run() {
        this.b.a(this.a, this.a.c.toString());
    }
}
