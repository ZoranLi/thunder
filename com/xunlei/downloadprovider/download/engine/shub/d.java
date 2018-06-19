package com.xunlei.downloadprovider.download.engine.shub;

import com.xunlei.downloadprovider.download.engine.util.b;

/* compiled from: GcidManager */
final class d implements c {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void a(b bVar, GcidInfo gcidInfo) {
        StringBuilder stringBuilder = new StringBuilder("onRequestComplete: ");
        stringBuilder.append(bVar.d);
        stringBuilder.append(" url = ");
        stringBuilder.append(bVar.a);
        this.a.d.b.remove(b.e(bVar.a));
        if (!(gcidInfo == null || b.f(gcidInfo.b) == null)) {
            this.a.d.a.put(this.a.b, gcidInfo);
        }
        if (this.a.c != null) {
            this.a.c.a(gcidInfo);
        }
    }
}
