package com.xunlei.downloadprovider.search.ui.search;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import java.net.URLEncoder;
import java.util.Random;

/* compiled from: MultiLoader */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ af d;
    final /* synthetic */ a e;

    k(String str, String str2, int i, af afVar, a aVar) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = afVar;
        this.e = aVar;
    }

    public final void run() {
        String str = this.a;
        String str2 = this.b;
        int i = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://api-shoulei-ssl.xunlei.com/searcher/res_search");
        stringBuilder.append("?timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        Random random = new Random(1000000000);
        stringBuilder.append("&nonce=");
        stringBuilder.append(random.nextLong());
        stringBuilder.append("&keyword=");
        stringBuilder.append(URLEncoder.encode(str));
        stringBuilder.append("&page=");
        stringBuilder.append(i);
        stringBuilder.append("&pagelen=10");
        stringBuilder.append("&type=");
        stringBuilder.append(str2);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(stringBuilder.toString(), new l(this), new m(this));
        sigJsonObjectRequest.setShouldCache(false);
        VolleyRequestManager.getMainThreadRequestQueue().a(sigJsonObjectRequest);
    }
}
