package com.xunlei.downloadprovider.ad.splash.view;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: SplashAdView */
final class c implements Callback {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.i();
        }
        return true;
    }
}
