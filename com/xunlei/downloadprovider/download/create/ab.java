package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;

/* compiled from: CreateUrlTaskActivity */
final class ab implements c {
    final /* synthetic */ CreateUrlTaskActivity a;

    ab(CreateUrlTaskActivity createUrlTaskActivity) {
        this.a = createUrlTaskActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        this.a.a = false;
        com.xunlei.downloadprovider.download.c.a(this.a, i, taskInfo.getTaskId());
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        this.a.a = false;
        this.a.finish();
        a.a(this.a, taskInfo.getTaskId(), DLCenterEntry.dl_center.toString());
    }
}
