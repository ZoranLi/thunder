package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: TaskDownloadCardViewHolder */
final class c implements OnLongClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    c(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final boolean onLongClick(View view) {
        if (this.a.isEditMode() != null) {
            return null;
        }
        a.c(a.a(this.a.mTaskInfo), this.a.getTabid());
        this.a.showTaskMoreOperationDialog();
        this.a.setTaskToSeen();
        return true;
    }
}
