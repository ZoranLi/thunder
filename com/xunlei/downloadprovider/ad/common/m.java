package com.xunlei.downloadprovider.ad.common;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.ad.common.l.a;

/* compiled from: RequestTimeoutMillisController */
final class m extends Handler {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.b = true;
            if (this.a.a != null) {
                message = this.a.a.iterator();
                while (message.hasNext()) {
                    ((a) message.next()).a();
                }
            }
        }
    }
}
