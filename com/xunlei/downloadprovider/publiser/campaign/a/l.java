package com.xunlei.downloadprovider.publiser.campaign.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: TopicNetWork */
final class l implements a {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.onFail(String.valueOf(f.a(volleyError)));
    }
}
