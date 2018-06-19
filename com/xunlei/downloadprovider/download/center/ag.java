package com.xunlei.downloadprovider.download.center;

import com.xunlei.downloadprovider.download.tasklist.task.h;

/* compiled from: DownloadCenterActivityFragment */
final class ag implements Runnable {
    final /* synthetic */ b a;

    ag(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.a > 0) {
            this.a.a = 0;
            this.a.b.q = true;
            this.a.b.E = true;
            h.e().d(0);
        }
        this.a.b.q = true;
        this.a.b.E = true;
    }
}
