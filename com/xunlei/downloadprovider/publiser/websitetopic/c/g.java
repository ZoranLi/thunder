package com.xunlei.downloadprovider.publiser.websitetopic.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: WebsiteTopicNetworkHelper */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.c.onFail(volleyError.toString());
    }
}
