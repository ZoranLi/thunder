package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: PushNetworkHelper */
final class f implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ b b;

    f(b bVar, boolean z) {
        this.b = bVar;
        this.a = z;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/push_services/peer/tags/?uid=");
        stringBuilder.append(LoginHelper.a().g.c());
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder.toString(), new g(this), new h(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
