package com.xunlei.downloadprovidershare.redpacket;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: RedPacketCashRequestManager */
final class e implements a {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getRedPacketCash error = ").append(volleyError.toString());
        if (this.a.b != null) {
            this.a.b.a();
        }
    }
}
