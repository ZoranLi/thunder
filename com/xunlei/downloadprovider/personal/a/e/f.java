package com.xunlei.downloadprovider.personal.a.e;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.personal.a.e.b.b;

/* compiled from: UserScoreManager */
final class f implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ b b;

    f(b bVar, b bVar2) {
        this.b = bVar;
        this.a = bVar2;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/user_score/web_api/get_can_gettable_score?", b.b(), new g(this), new h(this));
        sigJsonObjectRequest.setShouldCache(false);
        b.a(this.b).a(sigJsonObjectRequest);
    }
}
