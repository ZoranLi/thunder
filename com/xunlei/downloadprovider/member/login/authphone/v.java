package com.xunlei.downloadprovider.member.login.authphone;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: PhoneAuthHelper */
final class v implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ r b;

    v(r rVar, c cVar) {
        this.b = rVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        r.a(this.b);
        new StringBuilder("sendCode--jsonObject=").append(jSONObject.toString());
        obj = r$a.a(jSONObject);
        if (obj == null) {
            this.a.onFail("");
        } else {
            this.a.onSuccess(obj);
        }
    }
}
