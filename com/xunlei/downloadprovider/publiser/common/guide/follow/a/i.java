package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: GuideFollowNetwork */
final class i implements a {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.b.a(f.a(volleyError), f.b(volleyError));
    }
}
