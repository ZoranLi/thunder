package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.kernel.g;

/* compiled from: DownloadTaskManager */
public final class t implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ n b;

    public t(n nVar, long j) {
        this.b = nVar;
        this.a = j;
    }

    public final void run() {
        g.a().b(this.a);
        g.a().b(this.a, 0);
    }
}
