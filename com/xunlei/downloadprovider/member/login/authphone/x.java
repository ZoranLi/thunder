package com.xunlei.downloadprovider.member.login.authphone;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: PhoneAuthHelper */
final class x implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ r b;

    x(r rVar, c cVar) {
        this.b = rVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        r.a(this.b);
        new StringBuilder("authPhoneNumber--jsonObject=").append(jSONObject.toString());
        obj = r$a.a(jSONObject);
        if (obj == null) {
            this.b.d = true;
            this.a.onFail("");
            return;
        }
        if ("OK".equals(obj.a)) {
            this.b.d = false;
        } else {
            this.b.d = true;
        }
        this.a.onSuccess(obj);
        this.b.a.clear();
    }
}
