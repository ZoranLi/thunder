package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.app.BrothersApplication;
import org.json.JSONObject;

/* compiled from: RequestRedPacketManager */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a.a != null) {
            b a = b.a(jSONObject);
            this.a.a.a(a);
            if (!a.b) {
                com.xunlei.downloadprovider.h.f.a(BrothersApplication.getApplicationInstance(), "key_has_show_new_packet", true);
            }
            new StringBuilder("getIsNeedShowRedPacketGuide success = ").append(jSONObject.toString());
        }
    }
}
