package com.xunlei.downloadprovider.vod.manager;

import com.android.volley.Request;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.Map;

/* compiled from: MCPRequestManager */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ Map c;
    final /* synthetic */ c d;

    e(c cVar, String str, c cVar2, Map map) {
        this.d = cVar;
        this.a = str;
        this.b = cVar2;
        this.c = map;
    }

    public final void run() {
        Request hVar = new h(this, this.a, new f(this), new g(this));
        hVar.setShouldCache(false);
        this.d.a(hVar);
    }
}
