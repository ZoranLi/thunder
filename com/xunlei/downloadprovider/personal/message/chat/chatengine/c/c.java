package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChatBaseNetwork */
final class c implements a {
    final /* synthetic */ com.xunlei.downloadprovider.personal.message.chat.c a;
    final /* synthetic */ a b;

    c(a aVar, com.xunlei.downloadprovider.personal.message.chat.c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (a.a(this.a)) {
            a.b(volleyError, this.a);
        }
    }
}
