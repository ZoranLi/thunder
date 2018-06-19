package com.xunlei.downloadprovidershare.redpacket;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import java.util.Map;

/* compiled from: RedPacketCashRequestManager */
final class f extends SigJsonObjectRequest {
    final /* synthetic */ c a;

    f(c cVar, String str, b bVar, a aVar) {
        this.a = cVar;
        super(null, str, bVar, aVar);
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.put("Account-Id", "40");
        headers.put("App-Type", DispatchConstants.ANDROID);
        headers.put("Session-Id", this.a.c);
        headers.put("Peer-Id", this.a.d);
        return headers;
    }
}
