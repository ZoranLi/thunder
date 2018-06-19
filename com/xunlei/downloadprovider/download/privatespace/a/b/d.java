package com.xunlei.downloadprovider.download.privatespace.a.b;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.download.privatespace.a.a.f;
import org.json.JSONObject;

/* compiled from: BaseVerifyRequest */
public final class d implements b<JSONObject> {
    final /* synthetic */ com.xunlei.downloadprovider.member.payment.network.b a;
    final /* synthetic */ a b;

    public d(a aVar, com.xunlei.downloadprovider.member.payment.network.b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (this.a != null) {
            if (jSONObject != null) {
                jSONObject.toString();
                try {
                    int i = jSONObject.getInt("code");
                    obj = jSONObject.optString("msg");
                    if (i == 200) {
                        this.a.a(this.b.a);
                        return;
                    } else {
                        this.a.a(i, obj);
                        return;
                    }
                } catch (Object obj2) {
                    obj2.printStackTrace();
                }
            }
            this.a.a(-20000, f.a(-20000));
        }
    }
}
