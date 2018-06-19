package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.xunlei.downloadprovider.member.payment.ui.widget.PayMealAreaView.a;

/* compiled from: FloatFragment */
final class c implements a {
    final /* synthetic */ FloatFragment a;

    c(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void a() {
        this.a.s = this.a.d.getRealPayMonth();
        this.a.m.setOperateTip(this.a.d.getPayWard());
        FloatFragment.c(this.a);
        this.a.a();
        if (this.a.d.h()) {
            this.a.d.i();
        }
    }
}
