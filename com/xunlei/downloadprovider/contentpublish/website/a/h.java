package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsiteNetworkHelper */
public final class h implements a {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    public h(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getWebsiteDetailInfo ERROR =>").append(volleyError.getMessage());
        if (this.a != null) {
            this.a.onFail(volleyError.getMessage());
        }
    }
}
