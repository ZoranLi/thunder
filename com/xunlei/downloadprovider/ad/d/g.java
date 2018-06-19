package com.xunlei.downloadprovider.ad.d;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil$MessageListener;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: ShortMovieDetailAdController */
final class g implements HandlerUtil$MessageListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1000) {
            if (message.obj instanceof l) {
                this.a.a((l) message.obj);
                return;
            }
            this.a.a(null);
        }
    }
}
