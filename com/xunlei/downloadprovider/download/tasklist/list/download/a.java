package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TaskDownloadCardViewHolder */
final class a implements OnClickListener {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    a(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void onClick(View view) {
        this.a.fireOnTaskOpenClick();
    }
}
