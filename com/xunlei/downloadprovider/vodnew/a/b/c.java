package com.xunlei.downloadprovider.vodnew.a.b;

import com.xunlei.downloadprovider.vodnew.a.e.o.b;

/* compiled from: PlayerCallbackBroadcastDecorator */
final class c implements b {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar) {
        if (this.a.b != null) {
            this.a.b.a(cVar);
        }
        com.xunlei.downloadprovider.h.c.a(this.a.j, "ACTION_OnCompletion", a.a(this.a, 0));
    }
}
