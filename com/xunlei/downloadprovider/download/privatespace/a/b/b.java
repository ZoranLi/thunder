package com.xunlei.downloadprovider.download.privatespace.a.b;

import com.xunlei.downloadprovider.download.privatespace.a.a.f;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONObject;

/* compiled from: BaseVerifyRequest */
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
                    int i = jSONObject.getInt("code");
                    String optString = jSONObject.optString("msg");
                    if (i == 200) {
                        this.a.a(this.b.a, jSONObject.getJSONObject("data"));
                        return;
                    }
                    this.a.a(i, optString);
                    return;
                } catch (Object obj2) {
                    obj2.printStackTrace();
                }
            }
            this.a.a(-20000, f.a(-20000));
        }
    }
}
