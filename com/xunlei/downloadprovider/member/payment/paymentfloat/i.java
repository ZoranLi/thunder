package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.d.a;

/* compiled from: FloatFragment */
final class i implements OnClickListener {
    final /* synthetic */ FloatFragment a;

    i(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void onClick(View view) {
        FloatFragment.k(this.a);
        a l = FloatFragment.l(this.a);
        d.a(this.a.r, this.a.t, this.a.u, 3, this.a.e, this.a.u, this.a.s, this.a.p, "5.60.2.5510", -1, this.a.b(), l.a, l.b, false, this.a.B != null ? r0.a.B.c("taskid") : 0);
    }
}
