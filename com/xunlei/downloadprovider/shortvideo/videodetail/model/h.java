package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;

/* compiled from: ShortMovieDetailDataLoader */
final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ g c;

    h(g gVar, String str, boolean z) {
        this.c = gVar;
        this.a = str;
        this.b = z;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/ivideo_v5/info?peerid=");
        stringBuilder.append(AndroidConfig.getPeerid());
        stringBuilder.append("&movieid=");
        stringBuilder.append(this.a);
        stringBuilder.append("&time=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(this.b ? "&type=7" : "");
        Request sigJsonObjectRequest = new SigJsonObjectRequest(stringBuilder.toString(), new i(this), new l(this));
        sigJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
        sigJsonObjectRequest.setTag(this.c.e);
        this.c.f.a(sigJsonObjectRequest);
    }
}
