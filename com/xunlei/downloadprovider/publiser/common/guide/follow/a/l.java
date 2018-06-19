package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: GuideFollowNetwork */
final class l implements a {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a.a(f.a(volleyError), f.b(volleyError));
    }
}
