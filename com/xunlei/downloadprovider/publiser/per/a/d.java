package com.xunlei.downloadprovider.publiser.per.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: PublishNetworkHelper */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.a;
        new StringBuilder("getPublishList ERROR =>").append(volleyError.getMessage());
        volleyError.printStackTrace();
        this.a.d.a(volleyError.getMessage());
    }
}
