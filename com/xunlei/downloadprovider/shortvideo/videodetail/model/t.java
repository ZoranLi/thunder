package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;

/* compiled from: ShortMovieDetailDataLoader */
public final class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    public t(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, String.format("http://api-shoulei-ssl.xunlei.com/gamepool/api/game_extra/short_video/%s", new Object[]{this.a}), new u(this), new w(this));
        sigJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
        sigJsonObjectRequest.setTag(this.b.e);
        this.b.f.a(sigJsonObjectRequest);
    }
}
