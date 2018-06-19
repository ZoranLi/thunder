package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
final class l implements b<JSONObject> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        j.a(this.a.a, (JSONObject) obj);
    }
}
