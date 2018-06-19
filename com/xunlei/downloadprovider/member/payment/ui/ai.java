package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.payment.ui.widget.PayMealAreaView.a;

/* compiled from: PayOpenFragment */
final class ai implements a {
    final /* synthetic */ PayOpenFragment a;

    ai(PayOpenFragment payOpenFragment) {
        this.a = payOpenFragment;
    }

    public final void a() {
        this.a.u();
        this.a.e = this.a.q.getRealPayMonth();
        this.a.s();
        this.a.k.setOperateTip(this.a.q.getPayWard());
    }
}
