package com.xunlei.downloadprovider.download.giftdispatch.utils;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.volley.VolleyRequestManager;
import org.json.JSONArray;

/* compiled from: GiftDispatchingDataManager */
final class b implements Runnable {
    final /* synthetic */ JSONArray a;
    final /* synthetic */ a b;

    b(a aVar, JSONArray jSONArray) {
        this.b = aVar;
        this.a = jSONArray;
    }

    public final void run() {
        String str = "http://api-shoulei-ssl.xunlei.com/red_packets_cli/get_gift";
        a.b;
        Request eVar = new e(str, a.c(this.a), new c(this), new d(this, str));
        eVar.setRetryPolicy(new d(15000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(eVar);
    }
}
