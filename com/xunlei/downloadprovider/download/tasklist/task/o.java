package com.xunlei.downloadprovider.download.tasklist.task;

/* compiled from: TaskListManager */
final class o implements Runnable {
    final /* synthetic */ h a;

    o(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        do {
            this.a.p = 1;
            this.a.l();
        } while (this.a.p > 1);
    }
}
