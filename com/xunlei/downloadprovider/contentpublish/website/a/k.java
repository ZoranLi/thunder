package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: WebsiteNetworkHelper */
final class k implements a {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        this.a.b.a(String.valueOf(f.a(volleyError)));
    }
}
