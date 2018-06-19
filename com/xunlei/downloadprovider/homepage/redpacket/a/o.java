package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: RequestRedPacketProfit */
final class o implements a {
    final /* synthetic */ l a;

    o(l lVar) {
        this.a = lVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getRedPacketCash error = ").append(volleyError.toString());
        if (this.a.a != null) {
            k.j(new p(this, volleyError));
        }
    }
}
