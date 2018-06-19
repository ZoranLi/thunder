package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.cooperation.ui.a;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.m;

/* compiled from: ThunderTaskInteractionFragment */
final class am implements a {
    final /* synthetic */ m a;
    final /* synthetic */ TaskStatInfo b;
    final /* synthetic */ ThunderTaskInteractionFragment c;

    am(ThunderTaskInteractionFragment thunderTaskInteractionFragment, m mVar, TaskStatInfo taskStatInfo) {
        this.c = thunderTaskInteractionFragment;
        this.a = mVar;
        this.b = taskStatInfo;
    }

    public final void onCancel() {
        this.c.b(this.a, this.b);
    }

    public final void a() {
        com.xunlei.downloadprovider.download.engine.report.a.a(this.b.a, this.a.a.mDownloadUrl, 4, this.b);
        this.c.a(false);
    }

    public final void b() {
        this.c.b(this.a, this.b);
    }
}
