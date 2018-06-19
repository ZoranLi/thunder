package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.network.b;

/* compiled from: BaseLixianRequest */
final class g implements a {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    g(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            b bVar = this.a;
            this.b.a;
            bVar.a(a.c(volleyError), a.b(volleyError));
        }
    }
}
