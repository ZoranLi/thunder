package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: CounterNetWorkHelper */
final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ b g;
    final /* synthetic */ a h;
    final /* synthetic */ b i;

    l(b bVar, String str, int i, String str2, String str3, int i2, String str4, b bVar2, a aVar) {
        this.i = bVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = i2;
        this.f = str4;
        this.g = bVar2;
        this.h = aVar;
    }

    public final void run() {
        VolleyRequestManager.getMainThreadRequestQueue().a(new SigJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/counter/report", b.b(this.a, this.b, this.c, this.d, this.e, this.f), new m(this), new n(this)));
    }
}
