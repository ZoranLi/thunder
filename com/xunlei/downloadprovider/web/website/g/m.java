package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: WebsiteSyncServer */
final class m implements a {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        j.b();
        new StringBuilder("checkUserHasCollectionDataInServer onErrorResponse = ").append(volleyError.toString());
    }
}
