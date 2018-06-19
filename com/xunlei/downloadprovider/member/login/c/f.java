package com.xunlei.downloadprovider.member.login.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: LoginBusinessHelper */
final class f implements a {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        volleyError.printStackTrace();
        new StringBuilder("onErrorResponse notify server = ").append(volleyError.toString());
    }
}
