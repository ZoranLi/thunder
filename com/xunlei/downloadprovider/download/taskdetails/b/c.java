package com.xunlei.downloadprovider.download.taskdetails.b;

import android.os.Handler;
import android.os.Message;

/* compiled from: TaskCommentController */
final class c extends Handler {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 120) {
            this.a.z[1] = Boolean.valueOf(false);
            this.a.j.b(this.a.x);
            return;
        }
        if (message.what == 121) {
            this.a.z[1] = Boolean.valueOf(true);
            this.a.j.b(this.a.x);
        }
    }
}
