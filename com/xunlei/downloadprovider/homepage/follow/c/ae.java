package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: FollowNetworkHelper */
final class ae implements Runnable {
    final /* synthetic */ VolleyError a;
    final /* synthetic */ ad b;

    ae(ad adVar, VolleyError volleyError) {
        this.b = adVar;
        this.a = volleyError;
    }

    public final void run() {
        this.b.a.a.onFail(String.valueOf(f.a(this.a)));
    }
}
