package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.app.Activity;
import android.view.View;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.util.n.a;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;

/* compiled from: DownloadFreeTrialBanner */
final class d extends a {
    final /* synthetic */ View a;
    final /* synthetic */ a b;

    d(a aVar, Activity activity, TaskInfo taskInfo, String str, View view) {
        this.b = aVar;
        this.a = view;
        super(activity, taskInfo, str);
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        super.onShareComplete(i, shareOperationType, fVar);
        if (i == 0) {
            a.a(this.b, this.a, false);
        }
        com.xunlei.downloadprovider.download.c.a.a().g = false;
    }
}
