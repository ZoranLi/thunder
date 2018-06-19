package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;

final class g extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Handler b;

    g(Context context, Handler handler) {
        this.a = context;
        this.b = handler;
    }

    public final void run() {
        if (aj.a().a(true, this.a) == 0) {
            aj.a().b(this.a, true);
        }
        l.a(true).a(this.a, false, false);
        bk b = bk.b();
        b.a(this.a);
        boolean c = b.c();
        this.b.sendEmptyMessage(3);
        if (c) {
            this.b.sendEmptyMessage(1);
        } else {
            this.b.sendEmptyMessage(2);
        }
    }
}
