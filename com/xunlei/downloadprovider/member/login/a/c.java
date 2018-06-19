package com.xunlei.downloadprovider.member.login.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: AuthWechatHelper */
public final class c implements a {
    final /* synthetic */ a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        a.d;
        new StringBuilder("jonErrorResponse volleyError = ").append(volleyError.toString());
        this.a.a = false;
        if (this.a.c != null) {
            this.a.c.a();
            this.a.c = null;
        }
    }
}
