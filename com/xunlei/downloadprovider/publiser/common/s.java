package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: VisitorNetworkHelper */
final class s implements a {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
    }
}
