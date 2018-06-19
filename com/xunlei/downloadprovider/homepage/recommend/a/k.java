package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CounterNetWorkHelper */
final class k implements a {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("sendPlay onErrorResponse ").append(volleyError);
    }
}
