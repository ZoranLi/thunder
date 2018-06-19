package com.xunlei.downloadprovider.publiser.campaign.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.publiser.campaign.m;

/* compiled from: TopicNetWork */
final class g implements a {
    final /* synthetic */ c a;
    final /* synthetic */ boolean b;
    final /* synthetic */ m c;
    final /* synthetic */ e d;

    g(e eVar, c cVar, boolean z, m mVar) {
        this.d = eVar;
        this.a = cVar;
        this.b = z;
        this.c = mVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        e.a;
        if (this.a != null) {
            this.a.k();
        }
        if (this.b != null && this.c != null) {
            this.c.a(true);
        }
    }
}
