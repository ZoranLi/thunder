package com.xunlei.downloadprovider.homepage.youliao.data;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: YouliaoNetDataSource */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.c.b = false;
        if (volleyError == null || volleyError.networkResponse == null || volleyError.networkResponse.b == null) {
            new StringBuilder().append(volleyError);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(volleyError);
            stringBuilder.append("\n");
            stringBuilder.append(new String(volleyError.networkResponse.b));
        }
        c cVar = new c();
        cVar.d = true;
        cVar.c = volleyError;
        this.a.b.a(cVar);
    }
}
