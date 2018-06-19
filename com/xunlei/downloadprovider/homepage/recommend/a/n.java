package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CounterNetWorkHelper */
final class n implements a {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.h != null) {
            this.a.h.onErrorResponse(volleyError);
        }
    }
}
