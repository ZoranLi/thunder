package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: WebsiteSyncServer */
public final class k implements Runnable {
    final /* synthetic */ j a;

    public k(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        long c = LoginHelper.a().g.c();
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/fav_site/api/v2/store/new_user?uid=");
        stringBuilder.append(c);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder.toString(), new l(this), new m(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
