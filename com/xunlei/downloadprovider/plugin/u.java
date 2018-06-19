package com.xunlei.downloadprovider.plugin;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: XLPluginNetworkHelper */
final class u implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ t b;

    u(t tVar, c cVar) {
        this.b = tVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            t.b;
            new StringBuilder("getPluginInfos, response : ").append(jSONObject.toString());
            this.a.onSuccess(t.b(jSONObject));
            return;
        }
        this.a.onFail("response json is null");
    }
}
