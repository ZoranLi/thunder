package com.xunlei.downloadprovider.download.downloadvod;

import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadVodImpl */
final class e implements Runnable {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ d b;

    e(d dVar, TaskInfo taskInfo) {
        this.b = dVar;
        this.a = taskInfo;
    }

    public final void run() {
        if (!this.b.a.a) {
            if (this.a == null || this.a.getTaskId() <= 0) {
                this.b.a.a(null, null);
            } else {
                this.b.a.a(this.a, null);
            }
        }
    }
}
