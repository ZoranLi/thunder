package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CounterNetWorkHelper */
final class u implements a {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("likeVideosError=>").append(volleyError.getMessage());
        this.a.b.a(volleyError.getMessage());
    }
}
