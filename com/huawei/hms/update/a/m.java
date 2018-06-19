package com.huawei.hms.update.a;

import com.huawei.hms.update.a.a.c;

/* compiled from: ThreadWrapper */
class m implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ c b;
    final /* synthetic */ l c;

    m(l lVar, int i, c cVar) {
        this.c = lVar;
        this.a = i;
        this.b = cVar;
    }

    public void run() {
        this.c.a.a(this.a, this.b);
    }
}
