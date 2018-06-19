package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CounterNetWorkHelper */
final class r implements a {
    final /* synthetic */ p a;

    r(p pVar) {
        this.a = pVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("likeVideosError=>").append(volleyError.getMessage());
        this.a.c.onErrorResponse(volleyError);
    }
}
