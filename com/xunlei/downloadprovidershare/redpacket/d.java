package com.xunlei.downloadprovidershare.redpacket;

import com.android.volley.n.b;
import com.xunlei.downloadprovidershare.redpacket.b.a;
import org.json.JSONObject;

/* compiled from: RedPacketCashRequestManager */
final class d implements b<JSONObject> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("getRedPacketCash success = ").append(jSONObject.toString());
        if (this.a.b != null) {
            a aVar = this.a.b;
            a aVar2 = new a();
            if (jSONObject != null) {
                aVar2.a = jSONObject.optInt("operation_earn");
            }
            aVar.a(aVar2);
        }
    }
}
