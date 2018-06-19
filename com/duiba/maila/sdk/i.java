package com.duiba.maila.sdk;

import com.duiba.maila.sdk.util.d;

final class i implements Runnable {
    final /* synthetic */ Integer a;
    final /* synthetic */ d b;
    final /* synthetic */ MailaActivityInSdk c;

    i(MailaActivityInSdk mailaActivityInSdk, Integer num, d dVar) {
        this.c = mailaActivityInSdk;
        this.a = num;
        this.b = dVar;
    }

    public final void run() {
        this.c.j.put(this.a, this.b);
    }
}
