package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: FollowNetworkHelper */
final class ad implements a {
    final /* synthetic */ z a;

    ad(z zVar) {
        this.a = zVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.j(new ae(this, volleyError));
    }
}
