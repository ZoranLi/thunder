package com.xunlei.downloadprovider.plugin;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: XLPluginNetworkHelper */
final class v implements a {
    final /* synthetic */ c a;
    final /* synthetic */ t b;

    v(t tVar, c cVar) {
        this.b = tVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.a.onFail(String.valueOf(f.a(volleyError)));
    }
}
