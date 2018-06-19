package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PayFloatDialog */
final class v implements OnClickListener {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            this.a.g.onClick(this.a, -2);
        } else {
            this.a.dismiss();
        }
    }
}
