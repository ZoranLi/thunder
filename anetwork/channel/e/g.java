package anetwork.channel.e;

import anetwork.channel.d.a;
import anetwork.channel.entity.j;
import anetwork.channel.statist.StatisticData;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
final class g {
    public final j a;
    public a b;
    public final String c;
    public volatile StatisticData d = new StatisticData();
    public volatile AtomicBoolean e = new AtomicBoolean();
    public volatile c f = null;
    public volatile Future g = null;

    public g(j jVar, a aVar) {
        this.a = jVar;
        this.c = jVar.g;
        this.b = aVar;
        this.d.host = jVar.b.getHttpUrl().b();
    }

    public final void a() {
        Future future = this.g;
        if (future != null) {
            future.cancel(true);
            this.g = null;
        }
    }

    public final void b() {
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
    }
}
