package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTaskMoreOperationDialog */
final class ai implements OnClickListener {
    final /* synthetic */ af a;

    ai(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        if (!(this.a.h == null || this.a.g == null)) {
            view = this.a.h;
            TaskInfo a = this.a.g;
            if (a != null) {
                a.a("dl_more_open_type", a);
                d.a(view.a, a.mLocalFileName, true);
            }
        }
        this.a.dismiss();
    }
}
