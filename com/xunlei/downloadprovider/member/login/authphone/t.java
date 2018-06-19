package com.xunlei.downloadprovider.member.login.authphone;

import com.android.volley.n.b;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.json.JSONObject;

/* compiled from: PhoneAuthHelper */
final class t implements b<JSONObject> {
    final /* synthetic */ c a;
    final /* synthetic */ r b;

    t(r rVar, c cVar) {
        this.b = rVar;
        this.a = cVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        r.a(this.b);
        new StringBuilder("checkIsAuth--jsonObject=").append(jSONObject.toString());
        obj = r$a.a(jSONObject);
        if (obj != null) {
            if (this.a != null) {
                this.a.onSuccess(obj);
            }
            if ("ISAUTH".equals(obj.a) == null) {
                this.b.d = true;
            }
        } else if (this.a != null) {
            this.a.onFail("");
        }
    }
}
