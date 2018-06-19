package com.xunlei.downloadprovider.bho;

import android.content.Context;
import com.xunlei.downloadprovider.dialog.XLAlarmDialogActivity;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: BHOActivity */
final class a implements c {
    final /* synthetic */ BHOActivity a;

    a(BHOActivity bHOActivity) {
        this.a = bHOActivity;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        if (i != -2) {
            com.xunlei.downloadprovider.download.a.a(this.a, -1, "BHO");
        } else {
            Context context = this.a;
            long taskId = taskInfo.getTaskId();
            if (i == -2) {
                XLAlarmDialogActivity.a(context, taskId);
            }
        }
        this.a.finish();
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (taskInfo != null) {
            com.xunlei.downloadprovider.download.a.a(this.a, taskInfo.getTaskId(), "BHO");
        }
        this.a.finish();
    }
}
