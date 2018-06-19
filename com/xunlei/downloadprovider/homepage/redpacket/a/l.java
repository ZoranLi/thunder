package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: RequestRedPacketProfit */
final class l implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ k e;

    l(k kVar, c cVar, int i, String str, String str2) {
        this.e = kVar;
        this.a = cVar;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public final void run() {
        b mVar = new m(this);
        a oVar = new o(this);
        Request aVar = new a(this.b, this.c, mVar, oVar);
        if (this.b == 1) {
            aVar = new a(this.b, this.c, k.b(this.d), mVar, oVar);
        }
        aVar.setShouldCache(false).setRetryPolicy(new d(2000, 1, 1.0f));
        this.e.b(aVar);
    }
}
