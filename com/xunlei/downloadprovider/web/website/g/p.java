package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
final class p implements b<JSONObject> {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        j.a((JSONObject) obj, this.a.a);
    }
}
