package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class p implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ o b;

    p(o oVar, VolleyError volleyError) {
        this.b = oVar;
        this.a = volleyError;
    }

    public final void run() {
        this.b.a.c.a(String.valueOf(f.a(this.a)));
    }
}
