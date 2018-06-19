package com.xunlei.downloadprovider.personal.a.e;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.personal.a.e.b.a;

/* compiled from: UserScoreManager */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ b c;

    c(b bVar, String str, a aVar) {
        this.c = bVar;
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, this.a, new d(this), new e(this));
        sigJsonObjectRequest.setShouldCache(false);
        b.a(this.c).a(sigJsonObjectRequest);
    }
}
