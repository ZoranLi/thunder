package com.xunlei.downloadprovider.download.tasklist.task;

import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.b;

/* compiled from: TaskListManager */
final class p extends b {
    final /* synthetic */ h a;

    p(h hVar) {
        this.a = hVar;
    }

    public final void a() {
        if (this.a.r != null) {
            synchronized (this.a.s) {
                this.a.e(this.a.r);
            }
        }
    }
}
