package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: FollowNetworkHelper */
public final class z implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ a b;

    public z(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    public final void run() {
        this.b.b(new ar(0, "http://api-shoulei-ssl.xunlei.com/follow/uid_list", new aa(this), new ad(this)));
    }
}
