package com.xunlei.downloadprovider.download.control;

import com.xunlei.downloadprovider.cooperation.ui.a;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadCenterControl */
final class o implements a {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ a b;

    public final void b() {
    }

    public final void onCancel() {
    }

    o(a aVar, TaskInfo taskInfo) {
        this.b = aVar;
        this.a = taskInfo;
    }

    public final void a() {
        p.a().a(this.a, true);
    }
}
