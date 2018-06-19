package com.xunlei.downloadprovider.ad.common.adget;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.c.b$a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.ad.common.report.e;

/* compiled from: AgGet */
final class i implements a {
    final /* synthetic */ b$a a;
    final /* synthetic */ n b;
    final /* synthetic */ e c;

    i(e eVar, b$a com_xunlei_downloadprovider_ad_common_c_b_a, n nVar) {
        this.c = eVar;
        this.a = com_xunlei_downloadprovider_ad_common_c_b_a;
        this.b = nVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        int a = f.a(volleyError);
        volleyError = f.b(volleyError);
        this.a.a();
        e a2 = e.a(a, volleyError);
        k.a("adv_request_fail", k.a((THUNDER_AD_INFO) this.c.b.get(0), null, "xunlei", a2), this.a);
        this.b.a(a2.a, a2.b);
    }
}
