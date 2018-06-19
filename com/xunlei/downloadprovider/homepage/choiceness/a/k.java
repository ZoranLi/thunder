package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.Request;
import com.android.volley.d;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.search.b.b;

/* compiled from: ChoicenessNetworkHelper */
public final class k implements Runnable {
    final /* synthetic */ ChoicenessReporter$RefreshType a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ b d;
    final /* synthetic */ j e;

    public k(j jVar, ChoicenessReporter$RefreshType choicenessReporter$RefreshType, long j, long j2, b bVar) {
        this.e = jVar;
        this.a = choicenessReporter$RefreshType;
        this.b = j;
        this.c = j2;
        this.d = bVar;
    }

    public final void run() {
        j jVar = this.e;
        ChoicenessReporter$RefreshType choicenessReporter$RefreshType = this.a;
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/homepage/api/v2/refreshpage?id=");
        stringBuilder.append(this.b);
        Request arVar = new ar(j.a(jVar, choicenessReporter$RefreshType, stringBuilder.toString(), this.c), new l(this), new m(this));
        arVar.putHeader(HttpRequest.HEADER_USER_AGENT, AndroidConfig.getUserAgent());
        arVar.setShouldCache(false);
        arVar.setRetryPolicy(new d(10000, 1, 1.0f));
        this.e.a(arVar);
    }
}
