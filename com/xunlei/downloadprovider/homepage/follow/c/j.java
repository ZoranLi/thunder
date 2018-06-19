package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class j implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ i b;

    j(i iVar, VolleyError volleyError) {
        this.b = iVar;
        this.a = volleyError;
    }

    public final void run() {
        this.b.a.c.a(String.valueOf(f.a(this.a)));
    }
}
