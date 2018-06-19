package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskDownloadCardViewHolder */
final class m implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    m(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.mTaskInfo != null) {
            a.a("dl_fail_retry", "fail", this.a.getTabid(), a.b(this.a.mTaskInfo), this.a.mTaskInfo.mCreateOrigin);
        }
        this.a.fireOnTaskOperateClick(2);
    }
}
