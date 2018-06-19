package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.download.engine.a.a;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: ThunderTaskActivity */
final class ah implements c {
    final /* synthetic */ ThunderTaskActivity a;

    ah(ThunderTaskActivity thunderTaskActivity) {
        this.a = thunderTaskActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null) {
            a.a(this.a, taskInfo.getTaskDownloadUrl(), taskInfo.mTitle, false);
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null) {
            a.a(this.a, taskInfo.getTaskDownloadUrl(), taskInfo.mTitle, true);
            ThunderTaskActivity.a(this.a);
        }
    }
}
