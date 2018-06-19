package com.xunlei.downloadprovider.ad.common.adget.b;

import com.android.volley.Request;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import java.util.List;
import java.util.Map;

/* compiled from: MultiAgget */
final class e extends com.xunlei.downloadprovider.ad.common.adget.e {
    boolean c;
    Map<THUNDER_AD_INFO, com.xunlei.downloadprovider.ad.common.adget.j.a> d;
    private final String e;

    /* compiled from: MultiAgget */
    interface a {
        void a();

        void a(Map<THUNDER_AD_INFO, com.xunlei.downloadprovider.ad.common.adget.j.a> map);
    }

    public e(List<THUNDER_AD_INFO> list) {
        super(list != null ? (THUNDER_AD_INFO) list.get(0) : null);
        this.e = "xunlei";
        this.b = list;
    }

    final void a(a aVar) {
        if (!this.c) {
            this.c = true;
            k.b("adv_request", k.a(this.b, "xunlei"));
            com.xunlei.downloadprovider.ad.common.c.b.a aVar2 = new com.xunlei.downloadprovider.ad.common.c.b.a();
            aVar2.a = System.currentTimeMillis();
            Request aVar3 = new com.xunlei.downloadprovider.ad.common.adget.e.a(this, a(), new f(this, aVar2, aVar), new i(this, aVar2, aVar));
            aVar3.setShouldCache(null);
            VolleyRequestManager.getMainThreadRequestQueue().a(aVar3);
        }
    }
}
