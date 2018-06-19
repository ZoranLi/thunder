package com.xunlei.downloadprovider.ad.common.adget.b;

import com.android.volley.n.b;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.common.c.b.a;

/* compiled from: MultiAgget */
final class f implements b<String> {
    final /* synthetic */ a a;
    final /* synthetic */ a b;
    final /* synthetic */ e c;

    f(e eVar, a aVar, a aVar2) {
        this.c = eVar;
        this.a = aVar;
        this.b = aVar2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        this.a.a();
        XLThreadPool.execute(new h(this, str, new g(this)));
        this.c.c = false;
    }
}
