package com.xunlei.downloadprovider.homepage.youliao.data;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: YouliaoNetDataSource */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        this.a.c.b = false;
        this.a.c.a = this.a.c.a + 1;
        d.a(this.a.c, jSONObject, this.a.b, false);
    }
}
