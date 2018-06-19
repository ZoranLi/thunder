package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
final class q implements b<JSONObject> {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("likeVideos=>").append(jSONObject);
        this.a.b.onResponse(b.c(jSONObject));
    }
}
