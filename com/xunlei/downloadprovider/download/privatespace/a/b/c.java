package com.xunlei.downloadprovider.download.privatespace.a.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.network.d;

/* compiled from: BaseVerifyRequest */
final class c implements a {
    final /* synthetic */ d a;
    final /* synthetic */ a b;

    c(a aVar, d dVar) {
        this.b = aVar;
        this.a = dVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            this.a.a(a.a(volleyError), a.b(volleyError));
        }
    }
}
