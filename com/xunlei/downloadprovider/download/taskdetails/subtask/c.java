package com.xunlei.downloadprovider.download.taskdetails.subtask;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* compiled from: BTSubTaskListLoader */
final class c implements Callback {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            message = Looper.myLooper();
            if (message != null) {
                message.quit();
            }
        }
        return null;
    }
}
