package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChatNewUserNetwork */
final class f implements a {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("reportNewUser. fail. volleyErrorCode: ").append(c.a(volleyError));
        c.a(volleyError, this.a.b);
    }
}
