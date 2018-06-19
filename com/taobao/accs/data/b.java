package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor.a;

/* compiled from: Taobao */
class b implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    b(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public void run() {
        if (this.b.c != null) {
            this.b.c.a(this.a);
        }
    }
}
