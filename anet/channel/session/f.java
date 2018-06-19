package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* compiled from: Taobao */
class f implements Runnable {
    final /* synthetic */ Request a;
    final /* synthetic */ RequestStatistic b;
    final /* synthetic */ RequestCb c;
    final /* synthetic */ d d;

    f(d dVar, Request request, RequestStatistic requestStatistic, RequestCb requestCb) {
        this.d = dVar;
        this.a = request;
        this.b = requestStatistic;
        this.c = requestCb;
    }

    public void run() {
        b.a(this.a, new g(this));
    }
}
