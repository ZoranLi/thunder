package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.member.payment.a.e$e;

/* compiled from: VisitorNetworkHelper */
final class y implements a {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        e$e com_xunlei_downloadprovider_member_payment_a_e_e = this.a.d;
        String.valueOf(f.a(volleyError));
        com_xunlei_downloadprovider_member_payment_a_e_e.a();
    }
}
