package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: FollowNetworkHelper */
public final class q implements Runnable {
    final /* synthetic */ StringBuilder a;
    final /* synthetic */ c b;
    final /* synthetic */ a c;

    public q(a aVar, StringBuilder stringBuilder, c cVar) {
        this.c = aVar;
        this.a = stringBuilder;
        this.b = cVar;
    }

    public final void run() {
        this.c.a(new ar(0, this.a.toString(), new r(this), new s(this)));
    }
}
