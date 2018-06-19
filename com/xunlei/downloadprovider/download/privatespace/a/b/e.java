package com.xunlei.downloadprovider.download.privatespace.a.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.network.b;

/* compiled from: BaseVerifyRequest */
public final class e implements a {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    public e(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            this.a.a(a.a(volleyError), a.b(volleyError));
        }
    }
}
