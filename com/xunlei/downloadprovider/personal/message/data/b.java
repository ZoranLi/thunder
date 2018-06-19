package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n.a;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;

/* compiled from: CherryNetWork */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ com.android.volley.n.b b;
    final /* synthetic */ a c;
    final /* synthetic */ a d;

    b(a aVar, String str, com.android.volley.n.b bVar, a aVar2) {
        this.d = aVar;
        this.a = str;
        this.b = bVar;
        this.c = aVar2;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, this.a, this.b, this.c);
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
        this.d.d(sigJsonObjectRequest);
    }
}
