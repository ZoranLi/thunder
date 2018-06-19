package com.xunlei.downloadprovider.ad.home.a;

import android.os.Handler.Callback;
import android.os.Message;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.b;

/* compiled from: HomeAdReloadController */
final class d implements Callback {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 2000) {
            b.b(this.a, (b) message.obj);
        }
        return true;
    }
}
