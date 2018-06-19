package com.xunlei.downloadprovider.personal.a.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.personal.a.d.d;

/* compiled from: UserGridDataManager */
public final class c implements a {
    final /* synthetic */ d.a a;
    final /* synthetic */ a b;

    public c(a aVar, d.a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.c;
        new StringBuilder("requestFixedGridData onErrorResponse = ").append(volleyError.toString());
    }
}
