package com.xunlei.downloadprovider.personal.lixianspace.d;

import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: BaseLixianRequest */
final class b implements com.android.volley.n.b<JSONObject> {
    final /* synthetic */ d a;
    final /* synthetic */ a b;

    b(a aVar, d dVar) {
        this.b = aVar;
        this.a = dVar;
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
                        this.a.a(this.b.a, jSONObject.getJSONObject("data"));
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
