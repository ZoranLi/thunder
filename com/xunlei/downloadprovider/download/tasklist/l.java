package com.xunlei.downloadprovider.download.tasklist;

/* compiled from: TaskListPageFragment */
public final class l implements Runnable {
    final /* synthetic */ TaskListPageFragment a;

    public l(TaskListPageFragment taskListPageFragment) {
        this.a = taskListPageFragment;
    }

    public final void run() {
        if (this.a.isVisible()) {
            TaskListPageFragment.m(this.a);
        }
    }
}
