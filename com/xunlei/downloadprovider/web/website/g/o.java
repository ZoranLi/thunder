package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: WebsiteSyncServer */
final class o implements Runnable {
    final /* synthetic */ j$a a;
    final /* synthetic */ j b;

    o(j jVar, j$a com_xunlei_downloadprovider_web_website_g_j_a) {
        this.b = jVar;
        this.a = com_xunlei_downloadprovider_web_website_g_j_a;
    }

    public final void run() {
        long c = LoginHelper.a().g.c();
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/fav_site/api/v2/store?uid=");
        stringBuilder.append(c);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder.toString(), new p(this), new q(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
