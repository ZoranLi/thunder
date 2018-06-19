package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.xunlei.downloadprovider.ad.common.n;
import com.xunlei.downloadprovider.homepage.follow.c.ar;

/* compiled from: GuideFollowNetwork */
public final class j implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ f b;

    public j(f fVar, n nVar) {
        this.b = fVar;
        this.a = nVar;
    }

    public final void run() {
        this.b.a(new ar("http://api-shoulei-ssl.xunlei.com/follow/success_guide", new k(this), new l(this)));
    }
}
