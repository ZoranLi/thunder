package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CounterNetWorkHelper */
final class e implements a {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("sendLike onErrorResponse ").append(volleyError);
        new StringBuilder("sendLike onErrorResponse ").append(volleyError);
        if (this.a.e != null) {
            this.a.e.onErrorResponse(volleyError);
        }
    }
}
