package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.download.taskdetails.b.b;

/* compiled from: TaskDetailFragment */
final class al implements Runnable {
    final /* synthetic */ TaskDetailFragment a;

    al(TaskDetailFragment taskDetailFragment) {
        this.a = taskDetailFragment;
    }

    public final void run() {
        if (b.a(this.a.d)) {
            this.a.j.b(this.a.d);
        }
    }
}
