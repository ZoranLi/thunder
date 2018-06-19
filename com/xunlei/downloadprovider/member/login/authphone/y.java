package com.xunlei.downloadprovider.member.login.authphone;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PhoneAuthHelper */
final class y implements a {
    final /* synthetic */ c a;
    final /* synthetic */ r b;

    y(r rVar, c cVar) {
        this.b = rVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        r.a(this.b);
        new StringBuilder("authPhoneNumber--error=").append(volleyError.toString());
        this.b.d = true;
        this.a.onFail("");
    }
}
