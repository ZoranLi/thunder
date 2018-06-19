package com.xunlei.downloadprovider.cooperation;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: CooperationLoader */
final class i implements a {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        g.a(this.a, volleyError);
    }
}
