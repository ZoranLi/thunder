package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: WebsiteSyncServer */
final class q implements a {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a.b();
        j.b();
        new StringBuilder("queryAllUserCollection onErrorResponse = ").append(volleyError.toString());
    }
}
