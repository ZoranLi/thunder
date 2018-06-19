package com.xunlei.downloadprovider.web.browser.a.a;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.d.a.f;

/* compiled from: AdBlockConfig */
public final class c implements Runnable {
    final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/pss/static/misc/blacklist.json?rd=");
        stringBuilder.append(f.a());
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder.toString(), null, new d(), new e());
        sigJsonObjectRequest.setShouldCache(true);
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
