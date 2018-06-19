package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FloatFragment */
final class g implements OnClickListener {
    final /* synthetic */ FloatFragment a;

    g(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void onClick(View view) {
        this.a.getActivity().onBackPressed();
    }
}
