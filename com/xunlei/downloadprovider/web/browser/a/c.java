package com.xunlei.downloadprovider.web.browser.a;

import com.android.volley.Request;
import com.xunlei.common.net.thunderserver.request.SigStringRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.d.a.f;

/* compiled from: BrowserInjectHack */
public final class c implements Runnable {
    final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://static.m.sjzhushou.com/pss/static/android/HackPlayIconDown.js?rd=");
        stringBuilder.append(f.a());
        Request sigStringRequest = new SigStringRequest(0, stringBuilder.toString(), null, new d(), new e());
        sigStringRequest.setShouldCache(true);
        VolleyRequestManager.getRequestQueue().a(sigStringRequest);
    }
}
