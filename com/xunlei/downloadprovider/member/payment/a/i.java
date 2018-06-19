package com.xunlei.downloadprovider.member.payment.a;

import java.util.ArrayList;

/* compiled from: PayNetworkHelper */
final class i implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ f b;

    i(f fVar, ArrayList arrayList) {
        this.b = fVar;
        this.a = arrayList;
    }

    public final void run() {
        if (this.b.c != null) {
            this.b.c.a(this.a);
        }
    }
}
