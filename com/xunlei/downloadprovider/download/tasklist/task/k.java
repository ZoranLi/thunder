package com.xunlei.downloadprovider.download.tasklist.task;

import android.os.Handler;
import android.os.Message;

/* compiled from: TaskListManager */
final class k extends Handler {
    final /* synthetic */ h a;

    k(h hVar) {
        this.a = hVar;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == null) {
            this.a.d(0);
        }
    }
}
