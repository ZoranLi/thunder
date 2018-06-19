package com.xunlei.downloadprovider.d;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: OnlineConfigure */
final class h implements a {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    h(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        StringBuilder stringBuilder = new StringBuilder("downloadOnlineConfigure - ");
        stringBuilder.append(this.a);
        stringBuilder.append(" error: ");
        stringBuilder.append(volleyError.toString());
        if (this.b.b == null) {
            this.b.b();
        }
    }
}
