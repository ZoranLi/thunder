package com.xiaomi.metoknlp.b;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class d extends Handler {
    final /* synthetic */ c a;

    public d(c cVar, Looper looper) {
        this.a = cVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 200:
                synchronized (this.a.d) {
                    for (a a : this.a.d) {
                        a.a((NetworkInfo) message.obj);
                    }
                }
                return;
            case 201:
                synchronized (this.a.d) {
                    for (a a2 : this.a.d) {
                        a2.b((NetworkInfo) message.obj);
                    }
                }
                return;
            default:
                new StringBuilder("unknown message type: ").append(message.what);
                return;
        }
    }
}
