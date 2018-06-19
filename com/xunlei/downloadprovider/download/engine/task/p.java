package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.task.a.t.a;
import com.xunlei.downloadprovider.download.engine.task.a.t.b;

/* compiled from: DownloadTaskManager */
final class p extends a<b<Long, Long>> {
    final /* synthetic */ n a;

    p(n nVar, b bVar) {
        this.a = nVar;
        super(bVar);
    }

    public final /* synthetic */ void a(Object obj) {
        b bVar = (b) obj;
        g.a().a(((Long) bVar.a).longValue(), ((Long) bVar.b).longValue());
    }
}
