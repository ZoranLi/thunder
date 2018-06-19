package com.xunlei.downloadprovider.member;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: NewUserManager */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("requestNewUserFlag. failed ").append(volleyError.toString());
    }
}
