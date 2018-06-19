package com.xunlei.downloadprovider.publiser.websitetopic.c;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: WebsiteTopicNetworkHelper */
public final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;
    final /* synthetic */ d d;

    public e(d dVar, String str, String str2, c cVar) {
        this.d = dVar;
        this.a = str;
        this.b = str2;
        this.c = cVar;
    }

    public final void run() {
        Request arVar = new ar(0, d.a(this.a, this.b), new f(this), new g(this));
        arVar.setShouldCache(false);
        arVar.setRetryPolicy(new d(10000, 1, 1.0f));
        this.d.a(arVar);
    }
}
