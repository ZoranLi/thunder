package com.xunlei.downloadprovider.cooperation;

import com.xunlei.common.concurrent.XLThreadPool;
import java.util.Map;

/* compiled from: CooperationHelper */
final class d extends m {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    protected final void a() {
        a.a().b = this.d;
        c cVar = this.a;
        Map map = this.b;
        Map map2 = this.c;
        cVar.a.clear();
        cVar.a.putAll(map);
        cVar.b.clear();
        cVar.b.putAll(map2);
        XLThreadPool.execute(new e(cVar));
    }
}
