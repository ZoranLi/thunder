package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.network.c;
import org.json.JSONObject;

/* compiled from: BaseLixianRequest */
public final class d implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    public d(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a != null) {
            if (jSONObject != null) {
                jSONObject.toString();
                try {
                    int i = jSONObject.getInt("result");
                    String optString = jSONObject.optString("msg");
                    if (i == 0) {
                        obj = jSONObject.getJSONArray("data");
                        c cVar = this.a;
                        this.b.a;
                        cVar.a(obj);
                        return;
                    }
                    obj = this.a;
                    this.b.a;
                    obj.a(i, optString);
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
