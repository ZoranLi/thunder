package com.xunlei.downloadprovider.cardslide.likelist.c;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.cardslide.likelist.c.c.a;

/* compiled from: CardLikeNetHelper */
public final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ c c;

    public d(c cVar, String str, a aVar) {
        this.c = cVar;
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, c.a(this.a), new e(this), new f(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new com.android.volley.d(10000, 1, 1.0f));
        this.c.a.a(sigJsonObjectRequest);
    }
}
