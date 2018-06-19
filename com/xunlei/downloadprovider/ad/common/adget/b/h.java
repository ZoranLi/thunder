package com.xunlei.downloadprovider.ad.common.adget.b;

import android.os.Handler;

/* compiled from: MultiAgget */
final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Handler b;
    final /* synthetic */ f c;

    h(f fVar, String str, Handler handler) {
        this.c = fVar;
        this.a = str;
        this.b = handler;
    }

    public final void run() {
        this.c.c.d = l.a(this.c.c.b, this.a);
        this.b.sendEmptyMessage(0);
    }
}
