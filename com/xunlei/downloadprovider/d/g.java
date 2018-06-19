package com.xunlei.downloadprovider.d;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: OnlineConfigure */
final class g implements b<JSONObject> {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("downloadOnlineConfigure - ").append(jSONObject.toString());
        try {
            e.a(this.a, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.a.a(jSONObject, 2);
    }
}
