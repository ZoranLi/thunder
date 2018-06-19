package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class an implements a {
    final /* synthetic */ al a;

    an(al alVar) {
        this.a = alVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getFollowingLatestLiveStatus onErrorResponse=>").append(volleyError.getMessage());
        this.a.b.a(String.valueOf(f.a(volleyError)));
    }
}
