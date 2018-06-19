package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;

/* compiled from: MemberPriceHelper */
final class q implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ m b;

    q(m mVar, int i) {
        this.b = mVar;
        this.a = i;
    }

    public final void run() {
        synchronized (this.b.f) {
            m.a(this.b, this.a);
            if (this.b.g.get(this.a) == null) {
                m.c(this.b, this.a);
            } else {
                this.b.a(this.a, (OpenPriceParam) this.b.g.get(this.a));
            }
        }
    }
}
