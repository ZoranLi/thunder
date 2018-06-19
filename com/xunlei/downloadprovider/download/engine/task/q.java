package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.task.a.t.a;

/* compiled from: DownloadTaskManager */
final class q extends a<Long> {
    final /* synthetic */ n a;

    q(n nVar, Long l) {
        this.a = nVar;
        super(l);
    }

    public final /* synthetic */ void a(Object obj) {
        Long l = (Long) obj;
        g a = g.a();
        long longValue = l.longValue();
        if (longValue < 0) {
            longValue = -1;
        }
        if (a.b != null) {
            a.b.setSpeedLimit(longValue, -1);
        }
        obj = new StringBuilder("DownloadSDK: set DownloadSpeedLimit = ");
        obj.append(longValue);
        obj.append("KB/s");
    }
}
