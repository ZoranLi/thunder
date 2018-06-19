package com.xunlei.downloadprovider.download.tasklist;

/* compiled from: TaskListPageFragment */
final class m implements Runnable {
    final /* synthetic */ TaskListPageFragment a;

    m(TaskListPageFragment taskListPageFragment) {
        this.a = taskListPageFragment;
    }

    public final void run() {
        if (this.a.isVisible()) {
            TaskListPageFragment.m(this.a);
        }
    }
}
