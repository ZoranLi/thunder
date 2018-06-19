package com.xunlei.downloadprovider.download.create;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: ThunderTaskInteractionFragment */
final class al implements c {
    final /* synthetic */ ThunderTaskInteractionFragment a;

    al(ThunderTaskInteractionFragment thunderTaskInteractionFragment) {
        this.a = thunderTaskInteractionFragment;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        new StringBuilder("onFailure url = ").append(taskInfo.mUrl);
        if (i == -2) {
            this.a.a(taskInfo, i);
            return;
        }
        if (taskInfo.mIsToastForTask != null) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "创建任务失败,不可用的url!");
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        new StringBuilder("onSuccess taskId = ").append(taskInfo.getTaskId());
        if (taskInfo.mIsToastForTask != null) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "创建下载成功");
        }
    }
}
