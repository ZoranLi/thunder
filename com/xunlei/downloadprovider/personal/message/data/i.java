package com.xunlei.downloadprovider.personal.message.data;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;

/* compiled from: MessageNetWork */
final class i implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ MessageType b;
    final /* synthetic */ f c;
    final /* synthetic */ g d;

    i(g gVar, boolean z, MessageType messageType, f fVar) {
        this.d = gVar;
        this.a = z;
        this.b = messageType;
        this.c = fVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        g.b;
        if (this.a != null) {
            g.b(this.d, this.b);
            if (this.c != null) {
                this.c.a(this.d.a, this.a, this.b);
            }
        }
    }
}
