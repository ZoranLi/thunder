package com.xunlei.downloadprovider.ad.common.adget.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.c.b;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.report.e;

/* compiled from: MultiAgget */
final class i implements a {
    final /* synthetic */ b.a a;
    final /* synthetic */ a b;
    final /* synthetic */ e c;

    i(e eVar, b.a aVar, a aVar2) {
        this.c = eVar;
        this.a = aVar;
        this.b = aVar2;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.a();
        k.a("adv_request_fail", k.a(this.c.b, "xunlei", e.a(f.a(volleyError), f.b(volleyError))), this.a);
        this.b.a();
        this.c.c = false;
    }
}
