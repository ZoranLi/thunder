package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskDownloadCardViewHolder */
final class i implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    i(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        this.a.fireOnApkOpenClick();
    }
}
