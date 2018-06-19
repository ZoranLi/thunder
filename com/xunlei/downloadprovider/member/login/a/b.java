package com.xunlei.downloadprovider.member.login.a;

import org.json.JSONObject;

/* compiled from: AuthWechatHelper */
public final class b implements com.android.volley.n.b<JSONObject> {
    final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a.d;
        new StringBuilder("onResponse jsonObject = ").append(jSONObject.toString());
        this.a.a = false;
        if (this.a.c != null) {
            this.a.c.a(jSONObject);
            this.a.c = null;
        }
    }
}
