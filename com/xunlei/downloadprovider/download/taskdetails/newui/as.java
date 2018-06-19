package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: DownloadDetailsBeforePlayController */
final class as implements Callback {
    final /* synthetic */ DownloadDetailsBeforePlayController a;

    as(DownloadDetailsBeforePlayController downloadDetailsBeforePlayController) {
        this.a = downloadDetailsBeforePlayController;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1001) {
            DownloadDetailsBeforePlayController.a(this.a, message.arg1);
        }
        return true;
    }
}
