package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PayFloatDialog */
final class w implements OnClickListener {
    final /* synthetic */ u a;

    w(u uVar) {
        this.a = uVar;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            this.a.h.onClick(this.a, -1);
        } else {
            this.a.dismiss();
        }
    }
}
