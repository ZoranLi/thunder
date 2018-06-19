package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: VisitorNetworkHelper */
final class v implements a {
    final /* synthetic */ t a;

    v(t tVar) {
        this.a = tVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        this.a.b.a(0);
    }
}
