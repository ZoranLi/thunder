package com.xunlei.downloadprovider.notification;

import com.bumptech.glide.Glide;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadADNotification */
final class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ TaskInfo b;
    final /* synthetic */ DownloadADNotification c;

    a(DownloadADNotification downloadADNotification, String str, TaskInfo taskInfo) {
        this.c = downloadADNotification;
        this.a = str;
        this.b = taskInfo;
    }

    public final void run() {
        Glide.with(this.c.a).load(this.a).asBitmap().into(new b(this));
    }
}
