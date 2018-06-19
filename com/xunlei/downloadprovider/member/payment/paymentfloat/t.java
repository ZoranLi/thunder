package com.xunlei.downloadprovider.member.payment.paymentfloat;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.xllib.b.d;

/* compiled from: MemberPriceHelper */
final class t implements a {
    final /* synthetic */ m a;

    t(m mVar) {
        this.a = mVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (volleyError != null) {
            new StringBuilder("getPriceFromVipBusiness error=").append(volleyError.getLocalizedMessage());
        }
        if (d.a(this.a.h) == null) {
            for (Integer intValue : this.a.h) {
                m.c(this.a, intValue.intValue());
            }
            this.a.h.clear();
        }
    }
}
