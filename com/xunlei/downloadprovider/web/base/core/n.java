package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.a.m;

/* compiled from: DefaultJsInterface */
final class n implements c {
    final /* synthetic */ String a;
    final /* synthetic */ DefaultJsInterface b;

    n(DefaultJsInterface defaultJsInterface, String str) {
        this.b = defaultJsInterface;
        this.a = str;
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        i2 = BaseJsInterface.TAG;
        new StringBuilder("xlVideoPlay, onFailure, taskInfo : ").append(taskInfo);
        if (i != -2 || taskInfo == null) {
            taskInfo = BaseJsInterface.TAG;
            XLToast.showToast(this.b.getContext(), "创建下载失败");
            return;
        }
        i = BaseJsInterface.TAG;
        XLToast.showToast(this.b.getContext(), "开始为您下载并播放");
        m.a(this.b.getContext(), taskInfo, 0, this.a);
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        i = BaseJsInterface.TAG;
        new StringBuilder("xlVideoPlay, onSuccess, taskInfo : ").append(taskInfo);
        if (taskInfo != null) {
            XLToast.showToast(this.b.getContext(), "创建下载成功");
            m.a(this.b.getContext(), taskInfo, 0, this.a);
        }
    }
}
