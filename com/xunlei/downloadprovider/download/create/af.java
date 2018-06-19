package com.xunlei.downloadprovider.download.create;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.dialog.XLAlarmDialogActivity;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.xllib.android.e;

/* compiled from: GlobalTaskHandlerManager */
public final class af implements c {
    private static String b = "GlobalTaskHandlerManager";
    private static af c;
    public d a = new d(this);

    public static af a() {
        if (c == null) {
            c = new af();
        }
        return c;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        i2 = new StringBuilder("onFailure - ");
        i2.append(taskInfo);
        i2.append(" retCode = ");
        i2.append(i);
        if (i == -2) {
            XLAlarmDialogActivity.a(BrothersApplication.getApplicationInstance(), taskInfo.getTaskId());
        } else if (e.b() == null) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "USB存储模式下，SD卡暂不可写，请尝试重新插入SD卡");
        } else {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "创建任务失败，不可用的url!");
        }
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        i2 = new StringBuilder("onSuccess - ");
        i2.append(taskInfo);
        i2.append(" retCode = ");
        i2.append(i);
        if (taskInfo.mIsToastForTask != null) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "创建下载成功");
        }
    }
}
