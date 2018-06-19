package com.xunlei.downloadprovider.member.payment.voucher;

import java.util.List;

/* compiled from: ThunderVoucherProcessor */
final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ d c;

    h(d dVar, String str, boolean z) {
        this.c = dVar;
        this.a = str;
        this.b = z;
    }

    public final void run() {
        for (a a : (List) this.c.b.get(this.a)) {
            a.a(this.b);
        }
    }
}
