package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadDetailsBeforePlayController */
final class at implements OnClickListener {
    final /* synthetic */ DownloadDetailsBeforePlayController a;

    at(DownloadDetailsBeforePlayController downloadDetailsBeforePlayController) {
        this.a = downloadDetailsBeforePlayController;
    }

    public final void onClick(View view) {
        if (this.a.g == 3 && DownloadDetailsBeforePlayController.a(this.a) != null) {
            DownloadDetailsBeforePlayController.a(this.a).b();
        }
    }
}
