package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: FollowNetworkHelper */
final class o implements a {
    final /* synthetic */ k a;

    o(k kVar) {
        this.a = kVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getFollowingLatestVideoFeedList:error=>").append(volleyError.getMessage());
        a.j(new p(this, volleyError));
    }
}
