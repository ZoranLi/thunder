package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
final class d implements b<JSONObject> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("sendLike onResponse jsonObject=").append(jSONObject);
        new StringBuilder("sendLike onResponse jsonObject=").append(jSONObject);
        if (this.a.d != null) {
            this.a.d.onResponse(jSONObject);
        }
    }
}
