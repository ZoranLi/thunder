package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.personal.message.ad;
import org.json.JSONObject;

/* compiled from: MessageNetWork */
final class n implements b<JSONObject> {
    final /* synthetic */ ad a;
    final /* synthetic */ g b;

    n(g gVar, ad adVar) {
        this.b = gVar;
        this.a = adVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        g.b;
        new StringBuilder("getPersonalMessageUnRead onResponse=").append(jSONObject);
        g.a(jSONObject, this.a);
    }
}
