package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class aq implements a {
    final /* synthetic */ ao a;

    aq(ao aoVar) {
        this.a = aoVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.onFail(String.valueOf(f.a(volleyError)));
    }
}
