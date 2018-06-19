package com.xunlei.downloadprovider.personal.a.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.personal.a.d.d.b;

/* compiled from: UserGridDataManager */
public final class e implements a {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    public e(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.c;
        new StringBuilder("requestGridListData onErrorResponse = ").append(volleyError.toString());
        volleyError.printStackTrace();
        a.a(this.b);
        this.a.a();
    }
}
