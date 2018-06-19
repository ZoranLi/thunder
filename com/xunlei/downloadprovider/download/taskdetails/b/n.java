package com.xunlei.downloadprovider.download.taskdetails.b;

import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: TaskCommentController */
public final class n implements Runnable {
    final /* synthetic */ DownloadTaskInfo a;
    final /* synthetic */ b b;

    public n(b bVar, DownloadTaskInfo downloadTaskInfo) {
        this.b = bVar;
        this.a = downloadTaskInfo;
    }

    public final void run() {
        if (b.a(this.a)) {
            this.b.b(this.a);
        }
    }
}
