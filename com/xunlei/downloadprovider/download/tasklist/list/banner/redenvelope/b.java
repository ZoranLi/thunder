package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope;

import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: RedEnvelopeBannerHelper */
public final class b implements Runnable {
    final /* synthetic */ DownloadTaskInfo a;
    final /* synthetic */ long b;
    final /* synthetic */ a c;

    public b(a aVar, DownloadTaskInfo downloadTaskInfo, long j) {
        this.c = aVar;
        this.a = downloadTaskInfo;
        this.b = j;
    }

    public final void run() {
        if (this.a != this.c.f) {
            a.g(this.b);
            this.c.f = this.a;
        }
    }
}
