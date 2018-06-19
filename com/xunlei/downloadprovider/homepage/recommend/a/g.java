package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
final class g implements b<JSONObject> {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        new StringBuilder("sendShare onResponse jsonObject=").append((JSONObject) obj);
    }
}
