package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;

/* compiled from: MessageNetWork */
final class m implements a {
    final /* synthetic */ f a;
    final /* synthetic */ long b;
    final /* synthetic */ MessageType c;
    final /* synthetic */ g d;

    m(g gVar, f fVar, long j, MessageType messageType) {
        this.d = gVar;
        this.a = fVar;
        this.b = j;
        this.c = messageType;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        g.b;
        if (this.a != null) {
            this.a.a(this.b, this.c, false);
        }
    }
}
