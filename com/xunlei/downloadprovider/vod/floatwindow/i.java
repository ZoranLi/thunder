package com.xunlei.downloadprovider.vod.floatwindow;

import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.b;

/* compiled from: VodPlayerFloatWindow */
final class i implements b {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public final void a(c cVar) {
        a.v;
        if (this.a.f != null) {
            this.a.f.a(true);
        }
        this.a.c();
        if (cVar != null) {
            int n = cVar.n();
            a.v;
            StringBuilder stringBuilder = new StringBuilder("onCompletion, position : ");
            stringBuilder.append(n);
            stringBuilder.append(" duration : ");
            stringBuilder.append(n);
            this.a.a(n, n);
        }
    }
}
