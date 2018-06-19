package com.xunlei.downloadprovider.member.payment.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PayProblemActivity */
final class ap implements OnClickListener {
    final /* synthetic */ PayProblemActivity a;

    ap(PayProblemActivity payProblemActivity) {
        this.a = payProblemActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        PayProblemActivity.g(this.a);
    }
}
