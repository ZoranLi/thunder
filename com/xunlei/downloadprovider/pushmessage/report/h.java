package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: PushNetworkHelper */
final class h implements a {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.a != null) {
            this.a.b.a(false);
        }
    }
}
