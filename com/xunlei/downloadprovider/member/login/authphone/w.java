package com.xunlei.downloadprovider.member.login.authphone;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: PhoneAuthHelper */
final class w implements a {
    final /* synthetic */ c a;
    final /* synthetic */ r b;

    w(r rVar, c cVar) {
        this.b = rVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        r.a(this.b);
        new StringBuilder("sendCode--error=").append(volleyError.toString());
        this.a.onFail("");
    }
}
