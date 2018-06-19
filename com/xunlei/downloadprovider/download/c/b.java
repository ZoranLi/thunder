package com.xunlei.downloadprovider.download.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadFreeTrialHelper */
public final class b implements OnClickListener {
    final /* synthetic */ TaskInfo a;
    final /* synthetic */ a b;

    public b(a aVar, TaskInfo taskInfo) {
        this.b = aVar;
        this.a = taskInfo;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        p.a().a(this.a, true);
    }
}
