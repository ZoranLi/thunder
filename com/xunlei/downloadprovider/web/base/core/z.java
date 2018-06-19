package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: JsHttpClient */
final class z implements a {
    final /* synthetic */ a a;

    z(a aVar) {
        this.a = aVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError = (volleyError == null || volleyError.networkResponse == null) ? -1 : volleyError.networkResponse.a;
        if (this.a.f != null) {
            this.a.f.a(-1, volleyError, null);
        }
    }
}
