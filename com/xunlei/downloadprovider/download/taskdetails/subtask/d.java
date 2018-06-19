package com.xunlei.downloadprovider.download.taskdetails.subtask;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: BTSubTaskListLoader */
final class d implements Callback {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 100) {
            return null;
        }
        this.a.m.removeMessages(100);
        this.a.m.sendMessageDelayed(this.a.m.obtainMessage(100), 1000);
        b.b(this.a);
        if (this.a.t % 5 == 0) {
            b.d(this.a);
        }
        return true;
    }
}
