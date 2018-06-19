package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class ak implements a {
    final /* synthetic */ ai a;

    ak(ai aiVar) {
        this.a = aiVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getFollowingLiveList() onErrorResponse=>").append(volleyError.getMessage());
        this.a.b.a(String.valueOf(f.a(volleyError)));
    }
}
