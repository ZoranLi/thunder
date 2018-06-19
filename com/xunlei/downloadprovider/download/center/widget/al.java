package com.xunlei.downloadprovider.download.center.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadTaskMoreOperationDialog */
final class al implements OnClickListener {
    final /* synthetic */ aj a;

    al(aj ajVar) {
        this.a = ajVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        i = this.a.a.i != 0 ? this.a.a.i.getChecked() ^ 1 : 0;
        if (!(this.a.a.h == null || this.a.a.g == null)) {
            TaskInfo a = this.a.a.g;
            p.a().c(a, i);
            a.a().a(a);
        }
        if (this.a.a.g != null && this.a.a.g.getTaskStatus() != 8) {
            com.xunlei.downloadprovider.download.report.a.d("sure", this.a.a.g.mCreateOrigin);
        } else if (this.a.a.g != null) {
            String str = "sure";
            if (i != 0) {
                z = false;
            }
            com.xunlei.downloadprovider.download.report.a.a(str, z, this.a.a.g.mCreateOrigin);
        }
        dialogInterface.dismiss();
        this.a.a.dismiss();
    }
}
