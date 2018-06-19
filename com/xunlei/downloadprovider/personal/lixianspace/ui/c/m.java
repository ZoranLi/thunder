package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: LXSpaceTaskOperateDlg */
final class m implements c {
    final /* synthetic */ k a;

    public final void a(TaskInfo taskInfo, int i, int i2) {
    }

    m(k kVar) {
        this.a = kVar;
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        XLToast.showToast(this.a.getContext(), "创建下载成功");
    }
}
