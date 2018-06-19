package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
final class m implements b<JSONObject> {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("sendReport onResponse jsonObject=").append(jSONObject);
        if (this.a.g != null) {
            this.a.g.onResponse(jSONObject);
        }
    }
}
