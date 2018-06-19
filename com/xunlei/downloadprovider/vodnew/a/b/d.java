package com.xunlei.downloadprovider.vodnew.a.b;

import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.a;

/* compiled from: PlayerCallbackBroadcastDecorator */
final class d implements a {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void a(c cVar, int i) {
        if (this.a.c != null) {
            this.a.c.a(cVar, i);
        }
        cVar = a.a(this.a, 1);
        cVar.putInt("ACTION_OnBufferingUpdate_Percent", i);
        com.xunlei.downloadprovider.h.c.a(this.a.j, "ACTION_OnBufferingUpdate", cVar);
    }
}
