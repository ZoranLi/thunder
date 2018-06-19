package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: WebsiteSyncServer */
final class v implements a {
    final /* synthetic */ j a;

    v(j jVar) {
        this.a = jVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        j.b();
        new StringBuilder("syncUidData onErrorResponse = ").append(volleyError.toString());
    }
}
