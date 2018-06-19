package com.xunlei.downloadprovider.cardslide.c;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.cardslide.c.b.a;

/* compiled from: CardSlideRequestManager */
final class c implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    c(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, b.b(), new d(this), new e(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
        this.b.f.a(sigJsonObjectRequest);
    }
}
