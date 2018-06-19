package com.xunlei.downloadprovider.search.ui.search;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: MultiLoader */
final class m implements a {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.e != null) {
            this.a.e.b();
        }
        g.a = null;
    }
}
