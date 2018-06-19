package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.report.a;
import com.xunlei.downloadprovider.download.engine.task.m;

/* compiled from: ThunderTaskInteractionFragment */
final class ap implements OnClickListener {
    final /* synthetic */ m a;
    final /* synthetic */ TaskStatInfo b;
    final /* synthetic */ ThunderTaskInteractionFragment c;

    ap(ThunderTaskInteractionFragment thunderTaskInteractionFragment, m mVar, TaskStatInfo taskStatInfo) {
        this.c = thunderTaskInteractionFragment;
        this.a = mVar;
        this.b = taskStatInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        a.a(this.b.a, this.a.a.mDownloadUrl, 4, this.b);
        this.c.a((boolean) 0);
    }
}
