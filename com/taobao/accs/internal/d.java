package com.taobao.accs.internal;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    d(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public void run() {
        ALog.i("ElectionServiceImpl", "tryElection", new Object[]{"isPing", Boolean.valueOf(b.h)});
        if (b.h) {
            ALog.i("ElectionServiceImpl", "no need election, stop self", new Object[0]);
            this.b.a(true);
            return;
        }
        ALog.e("ElectionServiceImpl", "tryElection curr host unreceive ping, try selectAppToElection", new Object[]{"curr host", this.a});
        this.b.b(this.b.b, "host invaid");
    }
}
