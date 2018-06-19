package com.xunlei.downloadprovider.homepage.recommend.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: CounterNetWorkHelper */
final class j implements b<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        new StringBuilder("sendPlay onResponse jsonObject=").append((JSONObject) obj);
    }
}
