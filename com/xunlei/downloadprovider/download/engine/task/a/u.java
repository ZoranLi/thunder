package com.xunlei.downloadprovider.download.engine.task.a;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: MessageThread */
final class u implements Callback {
    final /* synthetic */ t a;

    u(t tVar) {
        this.a = tVar;
    }

    public final boolean handleMessage(Message message) {
        try {
            return (this.a.c == null || this.a.c.handleMessage(message) == null) ? null : true;
        } catch (Message message2) {
            message2.printStackTrace();
            return true;
        }
    }
}
