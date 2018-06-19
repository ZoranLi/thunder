package com.xunlei.downloadprovider.search.b;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: SearchNetworkHelper */
final class e implements b<JSONObject> {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            c.a(this.a.f, this.a.a, jSONObject, this.a.e);
        }
    }
}
