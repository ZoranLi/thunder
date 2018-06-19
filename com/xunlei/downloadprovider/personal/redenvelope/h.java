package com.xunlei.downloadprovider.personal.redenvelope;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.personal.redenvelope.g.a;

/* compiled from: RedPacketOpenHelper */
final class h implements Runnable {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, "http://api-shoulei-ssl.xunlei.com/red_packets_cli/get_rad_room_info", new i(this), new j(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
