package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class y implements a {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        this.a.b.onFail(String.valueOf(f.a(volleyError)));
    }
}
