package com.xunlei.downloadprovider.member.payment.voucher;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VoucherListDlg */
final class o implements OnClickListener {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.onCancel();
        }
        this.a.dismiss();
    }
}
