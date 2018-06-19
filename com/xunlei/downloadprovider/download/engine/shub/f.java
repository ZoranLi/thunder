package com.xunlei.downloadprovider.download.engine.shub;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: GcidManager */
final class f implements a {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        StringBuilder stringBuilder = new StringBuilder("Gcid ErrorResponse: ");
        stringBuilder.append(this.a.d);
        stringBuilder.append(" ");
        stringBuilder.append(volleyError);
        b.a(this.a);
    }
}
