package com.xunlei.downloadprovider.personal.score;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.score.h.b;

/* compiled from: UserScoreManager */
final class l implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ h b;

    l(h hVar, b bVar) {
        this.b = hVar;
        this.a = bVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, "http://api-shoulei-ssl.xunlei.com/duiba/shoulei/get_redirect_url?uid=%uid".replace("%uid", String.valueOf(LoginHelper.a().g.c())), new m(this), new n(this));
        sigJsonObjectRequest.setShouldCache(false);
        this.b.b.a(sigJsonObjectRequest);
    }
}
