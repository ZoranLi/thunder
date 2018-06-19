package com.xunlei.downloadprovider.download.create;

import com.xunlei.downloadprovider.cooperation.ui.a;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.m;

/* compiled from: ThunderTaskInteractionFragment */
final class an implements a {
    final /* synthetic */ m a;
    final /* synthetic */ TaskStatInfo b;
    final /* synthetic */ ThunderTaskInteractionFragment c;

    an(ThunderTaskInteractionFragment thunderTaskInteractionFragment, m mVar, TaskStatInfo taskStatInfo) {
        this.c = thunderTaskInteractionFragment;
        this.a = mVar;
        this.b = taskStatInfo;
    }

    public final void onCancel() {
        com.xunlei.downloadprovider.download.engine.report.a.a(this.b.a, this.a.a.mDownloadUrl, 4, this.b);
        this.c.a(false);
    }

    public final void a() {
        ThunderTaskInteractionFragment.b(this.c, this.a, this.b);
    }

    public final void b() {
        com.xunlei.downloadprovider.download.engine.report.a.a(this.b.a, this.a.a.mDownloadUrl, 4, this.b);
        this.c.a(false);
    }
}
