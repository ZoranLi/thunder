package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChatNewUserNetwork */
final class l implements a {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("reportSecondNotDownload. fail. volleyErrorCode: ").append(c.d(volleyError));
        c.d(volleyError, this.a.b);
    }
}
