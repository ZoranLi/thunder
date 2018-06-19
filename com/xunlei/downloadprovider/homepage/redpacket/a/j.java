package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: RequestRedPacketManager */
final class j implements a {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a.a != null) {
            new StringBuilder("getRedPacketNewInfo volleyError = ").append(volleyError.toString());
            this.a.a.a();
        }
    }
}
