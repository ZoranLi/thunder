package com.xunlei.downloadprovider.ad.a;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: HomeDownloadCenterADLoadController */
final class i implements Callback {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.e = true;
            this.a.b.post(new j(this.a));
        }
        return true;
    }
}
