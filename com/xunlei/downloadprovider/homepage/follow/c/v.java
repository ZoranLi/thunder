package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class v implements a {
    final /* synthetic */ t a;

    v(t tVar) {
        this.a = tVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.a(String.valueOf(f.a(volleyError)));
    }
}
