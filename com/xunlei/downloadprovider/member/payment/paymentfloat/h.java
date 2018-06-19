package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: FloatFragment */
final class h implements OnClickListener {
    final /* synthetic */ FloatFragment a;

    h(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void onClick(View view) {
        this.a.getActivity().onBackPressed();
        d.a(this.a.t, this.a.u, false, this.a.r, 3);
    }
}
