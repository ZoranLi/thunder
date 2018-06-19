package com.xunlei.downloadprovider.member.payment.voucher;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ThunderVoucherProcessor */
final class j implements a {
    final /* synthetic */ b a;
    final /* synthetic */ d b;

    j(d dVar, b bVar) {
        this.b = dVar;
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("checkCashState onErrorResponse").append(volleyError != null ? volleyError.getMessage() : "");
        d.a(this.a);
    }
}
