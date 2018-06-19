package com.xunlei.downloadprovider.personal.message.chat.personalchat.b;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChatNewUserNetwork */
final class i implements a {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("reportNotDownload. fail. volleyErrorCode: ").append(c.c(volleyError));
        c.c(volleyError, this.a.b);
    }
}
