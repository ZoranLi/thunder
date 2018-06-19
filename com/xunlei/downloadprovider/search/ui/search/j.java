package com.xunlei.downloadprovider.search.ui.search;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: MultiLoader */
final class j implements a {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.c != null) {
            this.a.c.b();
        }
    }
}
