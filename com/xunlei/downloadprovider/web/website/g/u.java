package com.xunlei.downloadprovider.web.website.g;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
final class u implements b<JSONObject> {
    final /* synthetic */ j a;

    u(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            j.b();
            new StringBuilder("syncUidData  result = ").append(jSONObject.getString("result"));
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
    }
}
