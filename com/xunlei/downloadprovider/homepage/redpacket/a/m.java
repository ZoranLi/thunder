package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: RequestRedPacketProfit */
final class m implements b<JSONObject> {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("getRedPacketCash success = ").append(jSONObject.toString());
        if (this.a.a != null) {
            k.j(new n(this, jSONObject));
        }
    }
}
