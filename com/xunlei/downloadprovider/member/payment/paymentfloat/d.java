package com.xunlei.downloadprovider.member.payment.paymentfloat;

import android.util.SparseArray;
import com.xunlei.downloadprovider.member.payment.bean.OpenPriceParam;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m.a;

/* compiled from: FloatFragment */
final class d implements a {
    final /* synthetic */ FloatFragment a;

    d(FloatFragment floatFragment) {
        this.a = floatFragment;
    }

    public final void a(int i, OpenPriceParam openPriceParam) {
        if (this.a.e == i) {
            this.a.n = openPriceParam;
            if (this.a.n == 0) {
                FloatFragment.u(this.a);
                return;
            }
            if (this.a.D == 0) {
                this.a.D = new SparseArray();
            }
            this.a.D.append(this.a.e, this.a.n);
            this.a.a(this.a.n);
        }
    }
}
