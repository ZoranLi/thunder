package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a.a.a;

/* compiled from: RedDetailManager */
public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ a c;

    public b(a aVar, String str, a aVar2) {
        this.c = aVar;
        this.a = str;
        this.b = aVar2;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, "http://api-shoulei-ssl.xunlei.com/red_packets_cli/info?id=%id".replace("%id", this.a), new c(this), new d(this));
        sigJsonObjectRequest.setShouldCache(false);
        this.c.b.a(sigJsonObjectRequest);
    }
}
