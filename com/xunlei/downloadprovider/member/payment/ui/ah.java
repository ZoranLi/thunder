package com.xunlei.downloadprovider.member.payment.ui;

import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.voucher.Voucher;
import com.xunlei.downloadprovider.member.payment.voucher.b;

/* compiled from: PayActivity */
final class ah implements b {
    final /* synthetic */ PayActivity a;

    ah(PayActivity payActivity) {
        this.a = payActivity;
    }

    public final void a(Voucher voucher) {
        if (!this.a.isFinishing()) {
            if (voucher != null && TextUtils.equals(this.a.f, voucher.b)) {
                this.a.q = voucher;
            }
            this.a.t();
        }
    }
}
