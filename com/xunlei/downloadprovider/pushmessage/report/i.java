package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import org.json.JSONObject;

/* compiled from: PushNetworkHelper */
public final class i implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    public i(b bVar, boolean z, String str) {
        this.c = bVar;
        this.a = z;
        this.b = str;
    }

    public final void run() {
        JSONObject a = b.a(this.a, this.b);
        StringBuilder stringBuilder = new StringBuilder("url=http://api-shoulei-ssl.xunlei.com/push_services/peer/tags/  ,result =");
        stringBuilder.append(this.a);
        stringBuilder.append(",details=");
        stringBuilder.append(this.b);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, "http://api-shoulei-ssl.xunlei.com/push_services/peer/tags/", a, new j(this), new k(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        b.b(this.c, sigJsonObjectRequest);
    }
}
