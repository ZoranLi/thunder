package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.l;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: CounterNetWorkHelper */
final class o implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ b b;
    final /* synthetic */ a c;

    o(StringBuilder stringBuilder, b bVar, a aVar) {
        this.a = stringBuilder;
        this.b = bVar;
        this.c = aVar;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, this.a.toString(), this.b, this.c);
        l requestQueue = VolleyRequestManager.getRequestQueue();
        sigJsonObjectRequest.setRetryPolicy(new d(10000, 2, 1.0f));
        requestQueue.a(sigJsonObjectRequest);
    }
}
