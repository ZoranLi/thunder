package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.kernel.g;

/* compiled from: DownloadTaskManager */
final class s implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ n c;

    s(n nVar, long j, long j2) {
        this.c = nVar;
        this.a = j;
        this.b = j2;
    }

    public final void run() {
        g.a().b(this.a, this.b);
    }
}
