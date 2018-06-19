package com.xunlei.downloadprovider.ad.cache.a;

import android.os.Handler.Callback;
import android.os.Message;
import java.util.Map;

/* compiled from: BaseCacheModel */
final class c implements Callback {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            if (message.obj instanceof Map) {
                try {
                    b.a(this.a, (Map) message.obj);
                } catch (Message message2) {
                    message2.getLocalizedMessage();
                }
            }
        }
        return true;
    }
}
