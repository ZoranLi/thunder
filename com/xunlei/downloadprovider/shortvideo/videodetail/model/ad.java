package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.Request;
import com.android.volley.d;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.m;
import java.util.Collections;

/* compiled from: ShortMovieDetailDataLoader */
final class ad implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ int c = null;
    final /* synthetic */ g d;

    ad(g gVar, String str, int i) {
        this.d = gVar;
        this.a = str;
        this.b = i;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("http://api-shoulei-ssl.xunlei.com/ivideo_v6/relation_v2?id=%s&size=%d&cursor=%d", new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c)}));
        stringBuilder.append("&time=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(m.a(Collections.singletonList(THUNDER_AD_INFO.SHORT_MOVIE_DETAIL_EFFECT), 4));
        Request sigJsonObjectRequest = new SigJsonObjectRequest(stringBuilder.toString(), new ae(this), new ah(this));
        sigJsonObjectRequest.putHeader(HttpRequest.HEADER_USER_AGENT, AndroidConfig.getUserAgent());
        sigJsonObjectRequest.setRetryPolicy(new d(10000, 1, 1.0f));
        sigJsonObjectRequest.setTag(this.d.e);
        this.d.f.a(sigJsonObjectRequest);
    }
}
