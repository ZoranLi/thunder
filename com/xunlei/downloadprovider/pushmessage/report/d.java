package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: PushNetworkHelper */
final class d implements b<JSONObject> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("onResponse jsonObject").append(jSONObject);
        b.a(this.a.k, this.a.i, jSONObject, this.a.h, this.a.a, this.a.b, this.a.c, this.a.d, this.a.e, this.a.f, this.a.g, this.a.j);
    }
}
