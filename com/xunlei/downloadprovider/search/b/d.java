package com.xunlei.downloadprovider.search.b;

import android.text.TextUtils;
import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.search.b.c.a;
import com.xunlei.xllib.b.k;

/* compiled from: SearchNetworkHelper */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b = 10;
    final /* synthetic */ int c = 0;
    final /* synthetic */ int d = 0;
    final /* synthetic */ a e;
    final /* synthetic */ c f;

    d(c cVar, String str, a aVar) {
        this.f = cVar;
        this.a = str;
        this.e = aVar;
    }

    public final void run() {
        String str = this.a;
        int i = this.b;
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/searcher/associate_search_v2?");
        stringBuilder.append("keyword=");
        stringBuilder.append(k.c(str, "utf-8"));
        stringBuilder.append("&size=");
        stringBuilder.append(i);
        Object stringBuilder2 = stringBuilder.toString();
        if (!TextUtils.isEmpty(stringBuilder2)) {
            Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder2, new e(this), new f(this));
            sigJsonObjectRequest.setShouldCache(false);
            this.f.b(sigJsonObjectRequest);
        }
    }
}
