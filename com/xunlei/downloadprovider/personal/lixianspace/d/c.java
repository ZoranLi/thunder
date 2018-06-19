package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.network.d;

/* compiled from: BaseLixianRequest */
final class c implements a {
    final /* synthetic */ d a;
    final /* synthetic */ a b;

    c(a aVar, d dVar) {
        this.b = aVar;
        this.a = dVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            d dVar = this.a;
            this.b.a;
            dVar.a(a.c(volleyError), a.b(volleyError));
        }
    }
}
