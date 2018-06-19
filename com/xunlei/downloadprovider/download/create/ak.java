package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: ThunderTaskInteractionActivity */
final class ak implements c {
    final /* synthetic */ ThunderTaskInteractionActivity a;

    ak(ThunderTaskInteractionActivity thunderTaskInteractionActivity) {
        this.a = thunderTaskInteractionActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        new StringBuilder("onFailure url = ").append(taskInfo.mUrl);
        if (i == -2) {
            this.a.a.a(taskInfo, i);
        } else {
            this.a.finish();
        }
        if (this.a.f != null) {
            this.a.f.a(taskInfo, i, i2);
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        new StringBuilder("onSuccess taskId = ").append(taskInfo.getTaskId());
        this.a.finish();
        if (this.a.f != null) {
            this.a.f.b(taskInfo, i, i2);
        }
    }
}
