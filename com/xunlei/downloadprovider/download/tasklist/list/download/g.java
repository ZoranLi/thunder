package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.speedup.c;

/* compiled from: TaskDownloadCardViewHolder */
final class g implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    g(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        if (this.a.mTaskInfo != null) {
            view = this.a.mTaskInfo;
            view.mRevision++;
        }
        c.c(this.a.mTaskInfo);
        this.a.mAdapter.notifyDataSetChanged();
    }
}
