package com.xunlei.downloadprovider.player.xmp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class z extends Handler {
    final /* synthetic */ XmpMediaPlayer a;

    z(XmpMediaPlayer xmpMediaPlayer, Looper looper) {
        this.a = xmpMediaPlayer;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            int i = message.arg1;
            int i2 = message.arg2;
            Iterator it = this.a.c.iterator();
            while (it.hasNext()) {
                ((aj) it.next()).a(i, i2);
            }
        }
    }
}
