package com.xunlei.downloadprovider.download.control;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadCenterControl */
final class c implements OnClickListener {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ a b;

    c(a aVar, TaskInfo taskInfo) {
        this.b = aVar;
        this.a = taskInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        p.a().a(this.a, true);
    }
}
