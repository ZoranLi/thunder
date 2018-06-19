package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: PushNetworkHelper */
final class e implements a {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.j != null) {
            this.a.k.a(this.a.i, this.a.h, this.a.a, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.g, false);
        }
    }
}
