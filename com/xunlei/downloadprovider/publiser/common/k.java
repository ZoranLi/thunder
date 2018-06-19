package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: PublisherDataNetworkHelper */
final class k implements a {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.c.onFail(String.valueOf(f.a(volleyError)));
    }
}
