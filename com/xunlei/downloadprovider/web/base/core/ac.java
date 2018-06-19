package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: JsHttpClient */
final class ac implements a {
    final /* synthetic */ d a;

    ac(d dVar) {
        this.a = dVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError = (volleyError == null || volleyError.networkResponse == null) ? -1 : volleyError.networkResponse.a;
        if (this.a.f != null) {
            this.a.f.a(-1, volleyError, null);
        }
    }
}
