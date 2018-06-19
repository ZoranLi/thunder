package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class s implements a {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getFollowingLatestVideoFeedStatus:error=>").append(volleyError.getMessage());
        this.a.b.onFail(String.valueOf(f.a(volleyError)));
    }
}
