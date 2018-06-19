package com.xunlei.downloadprovider.vodnew.a.b;

import android.os.Bundle;
import com.xunlei.downloadprovider.vodnew.a.e.o.c;

/* compiled from: PlayerCallbackBroadcastDecorator */
final class g implements c {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final boolean a(com.xunlei.downloadprovider.vodnew.a.d.c cVar, int i, int i2) {
        cVar = this.a.f != null ? this.a.f.a(cVar, i, i2) : null;
        Bundle a = a.a(this.a, 2);
        a.putInt("ACTION_OnError_What", i);
        a.putInt("ACTION_OnError_Extra", i2);
        com.xunlei.downloadprovider.h.c.a(this.a.j, "ACTION_OnError", a);
        return cVar;
    }
}
