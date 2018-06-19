package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: PublisherDataNetworkHelper */
final class l implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ c b;
    final /* synthetic */ String c;
    final /* synthetic */ h d;

    l(h hVar, JSONObject jSONObject, c cVar, String str) {
        this.d = hVar;
        this.a = jSONObject;
        this.b = cVar;
        this.c = str;
    }

    public final void run() {
        Request arVar = new ar(1, "http://api-shoulei-ssl.xunlei.com/ivideo_v4/delete", this.a, new m(this), new n(this));
        arVar.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        this.d.a(arVar);
    }
}
