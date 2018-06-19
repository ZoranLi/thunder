package anetwork.channel.e;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.StatObject;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.cache.Cache.Entry;

/* compiled from: Taobao */
public final class a implements c {
    private g a = null;
    private Cache b = null;
    private volatile boolean c = false;

    public a(g gVar, Cache cache) {
        this.a = gVar;
        this.b = cache;
    }

    public final void cancel() {
        this.c = true;
    }

    public final void run() {
        if (!this.c) {
            StatObject statObject = this.a.a.f;
            if (this.b != null) {
                String urlString = this.a.a.b.getUrlString();
                long currentTimeMillis = System.currentTimeMillis();
                Entry a = this.b.a(urlString);
                long currentTimeMillis2 = System.currentTimeMillis();
                statObject.cacheTime = currentTimeMillis2 - currentTimeMillis;
                if (ALog.isPrintLog(2)) {
                    String str = "anet.CacheTask";
                    String str2 = "read cache";
                    String str3 = this.a.c;
                    Object[] objArr = new Object[8];
                    objArr[0] = "hit";
                    objArr[1] = Boolean.valueOf(a != null);
                    objArr[2] = "cost";
                    objArr[3] = Long.valueOf(statObject.cacheTime);
                    objArr[4] = "length";
                    objArr[5] = Integer.valueOf(a != null ? a.data.length : 0);
                    objArr[6] = "key";
                    objArr[7] = urlString;
                    ALog.i(str, str2, str3, objArr);
                }
                if (a != null && a.isFresh()) {
                    if (this.a.e.compareAndSet(false, true)) {
                        this.a.a();
                        statObject.ret = true;
                        statObject.statusCode = 200;
                        statObject.protocolType = "cache";
                        statObject.oneWayTime = currentTimeMillis2 - statObject.start;
                        this.a.d.filledBy(statObject);
                        if (ALog.isPrintLog(2)) {
                            ALog.i("anet.CacheTask", "hit fresh cache", this.a.c, new Object[0]);
                            ALog.i("anet.CacheTask", this.a.d.toString(), this.a.c, new Object[0]);
                        }
                        this.a.b.a(200, a.responseHeaders);
                        this.a.b.a(1, a.data.length, ByteArray.wrap(a.data));
                        this.a.b.a(new DefaultFinishEvent(200, null, this.a.d));
                        AppMonitor.getInstance().commitStat(statObject);
                    }
                } else if (!this.c) {
                    Object dVar = new d(this.a, this.b, a);
                    this.a.f = dVar;
                    dVar.run();
                }
            }
        }
    }
}
