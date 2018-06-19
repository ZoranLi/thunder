package com.xunlei.downloadprovider.search.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: SearchNetworkHelper */
final class f implements a {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        c.j(new g(this));
    }
}
