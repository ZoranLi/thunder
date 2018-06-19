package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: RequestRedPacketManager */
final class g implements a {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.a != null) {
            this.a.a.a();
            new StringBuilder("getIsNeedShowRedPacketGuide failed = ").append(volleyError.toString());
        }
    }
}
