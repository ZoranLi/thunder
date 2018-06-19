package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CounterNetWorkHelper */
final class h implements a {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("sendShare onErrorResponse ").append(volleyError);
    }
}
