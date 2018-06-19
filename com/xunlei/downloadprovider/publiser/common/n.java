package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: PublisherDataNetworkHelper */
final class n implements a {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("deleteVideo error=>").append(volleyError.getMessage());
        this.a.b.onFail(String.valueOf(f.a(volleyError)));
        this.a.d.a.b();
    }
}
