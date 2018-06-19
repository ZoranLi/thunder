package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: RequestRedPacketManager */
final class i implements b<JSONObject> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a.a != null) {
            new StringBuilder("getRedPacketNewInfo onResponse = ").append(jSONObject.toString());
            this.a.a.a(b.a(jSONObject));
        }
    }
}
