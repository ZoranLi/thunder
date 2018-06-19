package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;

/* compiled from: CounterNetWorkHelper */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ b e;

    f(b bVar, String str, int i, String str2, String str3) {
        this.e = bVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    public final void run() {
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/counter/share", b.b(this.a, this.b, this.c, AndroidConfig.getPeerid(), this.d), new g(this), new h(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        this.e.a(sigJsonObjectRequest);
    }
}
