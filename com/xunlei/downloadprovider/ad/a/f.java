package com.xunlei.downloadprovider.ad.a;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: DownloadCenterADLoadController */
final class f implements Callback {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.f = true;
            this.a.d.post(new g(this.a));
        }
        return true;
    }
}
