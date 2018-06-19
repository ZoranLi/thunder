package com.xunlei.downloadprovider.publiser.per.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: PublishNetworkHelper */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.a;
        new StringBuilder("getDynamicList ERROR =>").append(volleyError.getMessage());
        volleyError.printStackTrace();
        this.a.d.a(volleyError.getMessage());
    }
}
