package com.xunlei.downloadprovider.personal.score;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.personal.score.h.a;

/* compiled from: UserScoreManager */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ h c;

    i(h hVar, String str, a aVar) {
        this.c = hVar;
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, this.a, new j(this), new k(this));
        sigJsonObjectRequest.setShouldCache(false);
        this.c.b.a(sigJsonObjectRequest);
    }
}
