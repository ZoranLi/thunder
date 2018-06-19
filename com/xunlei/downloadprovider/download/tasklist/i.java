package com.xunlei.downloadprovider.download.tasklist;

/* compiled from: TaskListPageFragment */
final class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        if (this.a.a.isVisible()) {
            TaskListPageFragment.m(this.a.a);
            TaskListPageFragment.o(this.a.a);
        }
    }
}
