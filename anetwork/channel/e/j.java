package anetwork.channel.e;

import anet.channel.request.Request;
import anet.channel.util.ALog;
import anetwork.channel.a.b;
import anetwork.channel.cache.Cache;
import anetwork.channel.cache.e;
import anetwork.channel.d.a;
import anetwork.channel.d.c;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
final class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        a aVar = new a(this.a, 0, this.a.a.a.b, this.a.a.b);
        Request request = this.a.a.a.b;
        a aVar2 = this.a.a.b;
        if (aVar.b.a.e.get()) {
            ALog.i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
        } else if (aVar.a < c.a()) {
            a aVar3 = new a(aVar.b, aVar.a + 1, request, aVar2);
            c.a(aVar.a);
        } else {
            Cache cache;
            aVar.b.a.a.b = request;
            aVar.b.a.b = aVar2;
            if (!b.f() || "no-cache".equals(request.getHeaders().get("Cache-Control"))) {
                cache = null;
            } else {
                aVar.b.a.a.b.getUrlString();
                cache = e.a(aVar.b.a.a.b.getHeaders());
            }
            aVar.b.a.f = cache != null ? new a(aVar.b.a, cache) : new d(aVar.b.a, null, null);
            anet.channel.a.c.a(aVar.b.a.f, 0);
            i iVar = aVar.b;
            iVar.a.g = anet.channel.a.c.a(new k(iVar), (long) iVar.a.a.a(), TimeUnit.MILLISECONDS);
        }
    }
}
