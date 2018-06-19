package com.xunlei.downloadprovider.member.payment.voucher;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ThunderVoucherProcessor */
final class g implements a {
    final /* synthetic */ String a;
    final /* synthetic */ d b;

    g(d dVar, String str) {
        this.b = dVar;
        this.a = str;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("get voucher onErrorResponse = ").append(volleyError != null ? volleyError.getMessage() : "");
        d.a(this.b, this.a, false);
    }
}
