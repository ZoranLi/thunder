package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class ah implements a {
    final /* synthetic */ af a;

    ah(af afVar) {
        this.a = afVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.a(String.valueOf(f.a(volleyError)));
    }
}
