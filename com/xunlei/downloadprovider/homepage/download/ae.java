package com.xunlei.downloadprovider.homepage.download;

import com.xunlei.downloadprovider.download.tasklist.task.h;

/* compiled from: DownloadTabFragment */
final class ae implements Runnable {
    final /* synthetic */ d a;

    ae(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.a > 0) {
            this.a.a = 0;
            this.a.b.a = true;
            h.e().d(0);
        }
        this.a.b.a = true;
    }
}
