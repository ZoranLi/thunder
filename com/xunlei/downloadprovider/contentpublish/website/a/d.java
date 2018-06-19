package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsiteNetworkHelper */
final class d implements a {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    d(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            this.a.onFail("publish_failed");
        }
    }
}
