package com.xunlei.downloadprovider.vodnew.a.b;

import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.i;

/* compiled from: PlayerCallbackBroadcastDecorator */
final class f implements i {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void a(c cVar, int i, int i2, int i3) {
        if (this.a.e != null) {
            this.a.e.a(cVar, i, i2, i3);
        }
        cVar = a.a(this.a, 3);
        cVar.putInt("ACTION_OnVideoSizeChanged_Width", i);
        cVar.putInt("ACTION_OnVideoSizeChanged_Height", i2);
        cVar.putInt("ACTION_OnVideoSizeChanged_duration", i3);
        com.xunlei.downloadprovider.h.c.a(this.a.j, "ACTION_OnVideoSizeChanged", cVar);
    }
}
