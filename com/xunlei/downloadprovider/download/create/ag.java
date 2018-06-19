package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: ThunderTaskActivity */
final class ag implements c {
    final /* synthetic */ ThunderTaskActivity a;

    ag(ThunderTaskActivity thunderTaskActivity) {
        this.a = thunderTaskActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        com.xunlei.downloadprovider.download.c.a(this.a, i, taskInfo.getTaskId());
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null && taskInfo.mExtraInfo != 0) {
            ThunderTaskActivity.a(this.a, taskInfo.mExtraInfo.mRefUrl);
        }
    }
}
