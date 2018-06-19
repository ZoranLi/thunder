package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.homepage.follow.c.ar;

/* compiled from: CounterNetWorkHelper */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;
    final /* synthetic */ a e;
    final /* synthetic */ b f;

    c(b bVar, String str, int i, String str2, b bVar2, a aVar) {
        this.f = bVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = bVar2;
        this.e = aVar;
    }

    public final void run() {
        Request arVar = new ar(1, "http://api-shoulei-ssl.xunlei.com/counter/praise", b.b(this.a, this.b, this.c, AndroidConfig.getPeerid()), new d(this), new e(this));
        arVar.setShouldCache(false);
        arVar.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        this.f.a(arVar);
    }
}
