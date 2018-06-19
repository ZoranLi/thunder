package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskDownloadCardViewHolder */
final class o implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    o(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.mTaskInfo != null) {
            a.a(this.a.mTaskInfo, this.a.getTabid());
        }
        this.a.fireOnTaskOperateClick(5);
    }
}
