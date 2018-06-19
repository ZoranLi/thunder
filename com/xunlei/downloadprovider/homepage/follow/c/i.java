package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: FollowNetworkHelper */
final class i implements a {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.j(new j(this, volleyError));
    }
}
