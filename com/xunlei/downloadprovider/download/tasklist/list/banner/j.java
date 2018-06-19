package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: BannerOnlineServerHelper */
final class j implements Runnable {
    j() {
    }

    public final void run() {
        String stringBuilder;
        LoginHelper.a();
        if (l.c()) {
            long c = LoginHelper.a().g.c();
            StringBuilder stringBuilder2 = new StringBuilder("http://try.speed.cdn.vip.xunlei.com/static/userid/");
            stringBuilder2.append(c);
            stringBuilder = stringBuilder2.toString();
        } else {
            BannerManager.a();
            stringBuilder = BannerManager.f();
            StringBuilder stringBuilder3 = new StringBuilder("http://try.speed.cdn.vip.xunlei.com/static/peerid/");
            stringBuilder3.append(stringBuilder);
            stringBuilder = stringBuilder3.toString();
        }
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder, new k(this), new l(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
