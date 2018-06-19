package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadDetailsBeforePlayController */
final class av implements OnClickListener {
    final /* synthetic */ DownloadDetailsBeforePlayController a;

    av(DownloadDetailsBeforePlayController downloadDetailsBeforePlayController) {
        this.a = downloadDetailsBeforePlayController;
    }

    public final void onClick(View view) {
        if (DownloadDetailsBeforePlayController.a(this.a) != null) {
            DownloadDetailsBeforePlayController.a(this.a).a();
        }
    }
}
