package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.homepage.follow.c.ar;

/* compiled from: GuideFollowNetwork */
public final class g implements Runnable {
    final /* synthetic */ int a = 8;
    final /* synthetic */ n b;
    final /* synthetic */ f c;

    public g(f fVar, n nVar) {
        this.c = fVar;
        this.b = nVar;
    }

    public final void run() {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/follow/guide_recommend?size=");
        stringBuilder.append(this.a);
        this.c.a(new ar(stringBuilder.toString(), new h(this), new i(this)));
    }
}
