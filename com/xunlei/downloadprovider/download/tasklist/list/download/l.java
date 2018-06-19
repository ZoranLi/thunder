package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskDownloadCardViewHolder */
final class l implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    l(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.mTaskInfo != null) {
            this.a.mTaskInfo.mCreateOrigin = "re_download";
            a.a("dl_finish_download", "finish", this.a.getTabid(), a.b(this.a.mTaskInfo), this.a.mTaskInfo.mCreateOrigin);
        }
        this.a.fireOnTaskOperateClick(3);
    }
}
