package com.xunlei.downloadprovider.vodnew.a.b;

import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.g;

/* compiled from: PlayerCallbackBroadcastDecorator */
final class e implements g {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void a(c cVar) {
        if (this.a.d != null) {
            this.a.d.a(cVar);
        }
        com.xunlei.downloadprovider.h.c.a(this.a.j, "ACTION_OnSeekComplete", a.a(this.a, 0));
    }
}
