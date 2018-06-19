package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.network.c;

/* compiled from: BaseLixianRequest */
public final class e implements a {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    public e(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            c cVar = this.a;
            this.b.a;
            cVar.a(a.c(volleyError), a.b(volleyError));
        }
    }
}
