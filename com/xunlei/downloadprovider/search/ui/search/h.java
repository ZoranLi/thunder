package com.xunlei.downloadprovider.search.ui.search;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import java.net.URLEncoder;
import java.util.Random;

/* compiled from: MultiLoader */
public final class h implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ab b;
    final /* synthetic */ a c;

    public h(String str, ab abVar, a aVar) {
        this.a = str;
        this.b = abVar;
        this.c = aVar;
    }

    public final void run() {
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://api-shoulei-ssl.xunlei.com/searcher/all_search_v3");
        stringBuilder.append("?timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        Random random = new Random(1000000000);
        stringBuilder.append("&nonce=");
        stringBuilder.append(random.nextLong());
        stringBuilder.append("&keyword=");
        stringBuilder.append(URLEncoder.encode(str));
        stringBuilder.append("&video_size=10");
        stringBuilder.append("&pub_size=10");
        stringBuilder.append("&site_size=10");
        Request sigJsonObjectRequest = new SigJsonObjectRequest(stringBuilder.toString(), new i(this), new j(this));
        sigJsonObjectRequest.setShouldCache(false);
        VolleyRequestManager.getMainThreadRequestQueue().a(sigJsonObjectRequest);
    }
}
