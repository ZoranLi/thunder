package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.ui.widget.PaymentTypeView.a;

/* compiled from: BasePayPageFragment */
final class v implements a {
    final /* synthetic */ BasePayPageFragment a;

    v(BasePayPageFragment basePayPageFragment) {
        this.a = basePayPageFragment;
    }

    public final void a(int i) {
        this.a.b();
        d.a(((PayActivity) this.a.getActivity()).a, this.a.i.getPayType(), this.a.d);
    }
}
