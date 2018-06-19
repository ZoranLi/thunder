package com.xunlei.downloadprovider.ad.splash;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: CountDownCounter */
final class b implements Callback {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final boolean handleMessage(Message message) {
        if (this.a.c != null) {
            return true;
        }
        synchronized (this.a) {
            if (this.a.a > 0) {
                this.a.a(this.a.a);
                this.a.a -= this.a.b;
                this.a.e.sendEmptyMessageDelayed(1, this.a.b);
            } else {
                this.a.a();
            }
        }
        return true;
    }
}
