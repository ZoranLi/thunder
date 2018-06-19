package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: RedDetailManager */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.a(volleyError);
        new StringBuilder("volleyError == ").append(volleyError.toString());
    }
}
