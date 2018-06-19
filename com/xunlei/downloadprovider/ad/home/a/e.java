package com.xunlei.downloadprovider.ad.home.a;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: HomeAdReloadController */
final class e implements Callback {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            if (b.c(this.a) != null) {
                Message obtainMessage = b.c(this.a).obtainMessage(2000);
                obtainMessage.obj = message.obj;
                b.c(this.a).sendMessage(obtainMessage);
            }
        }
        return true;
    }
}
