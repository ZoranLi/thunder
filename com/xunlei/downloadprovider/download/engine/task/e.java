package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: CreateTaskCallbackDelivery */
final class e implements Runnable {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ d d;

    e(d dVar, TaskInfo taskInfo, int i, int i2) {
        this.d = dVar;
        this.a = taskInfo;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        if (this.d.a != null) {
            this.d.a.a(this.a, this.b, this.c);
        }
    }
}
