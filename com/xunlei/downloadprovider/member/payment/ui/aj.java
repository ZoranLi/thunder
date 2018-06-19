package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m.a;

/* compiled from: PayOpenFragment */
final class aj implements a {
    final /* synthetic */ PayOpenFragment a;

    aj(PayOpenFragment payOpenFragment) {
        this.a = payOpenFragment;
    }

    public final void a(int i, OpenPriceParam openPriceParam) {
        if (i != this.a.f) {
            String.format("[onPriceLoad] cur page vasType=%d, result vasType=%d", new Object[]{Integer.valueOf(this.a.f), Integer.valueOf(i)});
        } else if (this.a.getActivity() != 0) {
            if (openPriceParam == null) {
                this.a.g();
                d.a(PayBaseConstants.PAY_PAGE_SHOW_FAIL, ((PayActivity) this.a.getActivity()).o, ((PayActivity) this.a.getActivity()).n, this.a.h.getType());
                return;
            }
            PayOpenFragment.a(this.a, openPriceParam);
        }
    }
}
