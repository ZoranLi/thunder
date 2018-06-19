package com.xunlei.downloadprovider.app.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.a.d.a;

/* compiled from: InitializationWrapper */
final class g implements Callback {
    a a;
    private c b;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private Handler e = new Handler(Looper.getMainLooper(), this);

    g(c cVar) {
        this.b = cVar;
    }

    final void a() {
        this.b.a(false);
        this.c = true;
        c();
    }

    final void b() {
        XLThreadPool.execute(new h(this));
    }

    private synchronized void c() {
        if (this.c && this.d) {
            this.e.removeCallbacksAndMessages(null);
            if (this.a != null) {
                this.a.a();
            }
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            c();
        }
        return true;
    }
}
