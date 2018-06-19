package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.a.t.a;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: CoreTaskManager */
public final class g extends a<TaskInfo> {
    final /* synthetic */ c a;

    public g(c cVar, TaskInfo taskInfo) {
        this.a = cVar;
        super(taskInfo);
    }

    public final /* synthetic */ void a(Object obj) {
        TaskInfo taskInfo = (TaskInfo) obj;
        taskInfo.syncExtraInfo();
        this.a.h.a(taskInfo.mExtraInfo);
    }
}
