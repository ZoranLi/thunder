package com.xunlei.downloadprovider.homepage.cinecism.a;

import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: CinecismNetworkHelper */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    b(String str, c cVar) {
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/cinecism/info?id=");
        stringBuilder.append(this.a);
        VolleyRequestManager.getMainThreadRequestQueue().a(new ar(stringBuilder.toString(), new c(this), new d(this)));
    }
}
