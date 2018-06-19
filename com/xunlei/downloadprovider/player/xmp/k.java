package com.xunlei.downloadprovider.player.xmp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: PlayerLikeGuideHelper */
final class k extends Handler {
    final /* synthetic */ j a;

    k(j jVar, Looper looper) {
        this.a = jVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            int i = message.arg1;
            this.a.a((String) message.obj, i);
        }
    }
}
