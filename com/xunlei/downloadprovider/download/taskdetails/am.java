package com.xunlei.downloadprovider.download.taskdetails;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* compiled from: TaskDetailFragment */
final class am implements Callback {
    final /* synthetic */ TaskDetailFragment a;

    am(TaskDetailFragment taskDetailFragment) {
        this.a = taskDetailFragment;
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
