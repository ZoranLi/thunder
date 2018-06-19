package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: BannerOnlineServerHelper */
final class m implements Runnable {
    m() {
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/red_packets_cli/user/user_portrait", a.a(), new n(this), new o(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
