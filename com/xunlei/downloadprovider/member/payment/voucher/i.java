package com.xunlei.downloadprovider.member.payment.voucher;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: ThunderVoucherProcessor */
final class i implements b<JSONObject> {
    final /* synthetic */ b a;
    final /* synthetic */ d b;

    i(d dVar, b bVar) {
        this.b = dVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.getInt("result") != 0) {
                d.a(this.a);
                return;
            }
            jSONObject = jSONObject.getJSONObject("data");
            if (jSONObject.getInt("codeState") != 0) {
                d.a(this.a);
                return;
            }
            obj = Voucher.a(jSONObject);
            if (this.a != null) {
                this.a.a(obj);
            }
        } catch (Object obj2) {
            d.a(this.a);
            new StringBuilder("check voucher state response invalid = ").append(obj2.toString());
        }
    }
}
