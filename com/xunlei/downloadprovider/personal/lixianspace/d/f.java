package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: BaseLixianRequest */
final class f implements b<JSONObject> {
    final /* synthetic */ com.xunlei.downloadprovider.member.payment.network.b a;
    final /* synthetic */ a b;

    f(a aVar, com.xunlei.downloadprovider.member.payment.network.b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a != null) {
            if (jSONObject != null) {
                jSONObject.toString();
                try {
                    int i = jSONObject.getInt("result");
                    obj = jSONObject.optString("msg");
                    if (i == 0) {
                        this.a.a(this.b.a);
                        return;
                    }
                    com.xunlei.downloadprovider.member.payment.network.b bVar = this.a;
                    this.b.a;
                    bVar.a(i, obj);
                    return;
                } catch (Object obj2) {
                    obj2.printStackTrace();
                    obj2 = this.a;
                    this.b.a;
                    obj2.a(-20000, p.a(-20000));
                    return;
                }
            }
            obj2 = this.a;
            this.b.a;
            obj2.a(-20000, p.a(-20000));
        }
    }
}
