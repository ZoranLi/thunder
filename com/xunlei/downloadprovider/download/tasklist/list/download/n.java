package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskDownloadCardViewHolder */
final class n implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    n(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.mTaskInfo != null) {
            a.c(this.a.mTaskInfo, this.a.getTabid());
        }
        this.a.fireOnTaskOperateClick(2);
    }
}
