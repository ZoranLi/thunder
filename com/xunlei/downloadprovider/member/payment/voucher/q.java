package com.xunlei.downloadprovider.member.payment.voucher;

import android.text.TextUtils;

/* compiled from: VoucherListDlg */
final class q implements b {
    final /* synthetic */ String a;
    final /* synthetic */ p b;

    q(p pVar, String str) {
        this.b = pVar;
        this.a = str;
    }

    public final void a(Voucher voucher) {
        if (voucher == null) {
            this.b.a.c.a(this.a);
            this.b.a.a.notifyDataSetChanged();
            return;
        }
        boolean equals = TextUtils.equals(this.a, this.b.a.a.e);
        b.b(this.b.a.a, equals ? null : this.a);
        if (this.b.a.b != null) {
            a a = this.b.a.b;
            if (equals) {
                voucher = null;
            }
            a.a(voucher);
        }
        this.b.a.dismiss();
    }
}
