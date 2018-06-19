package com.xunlei.downloadprovider.homepage.recommend;

import com.xunlei.downloadprovider.homepage.recommend.feed.p;

/* compiled from: SummaryMoviesFeedView */
final class e implements p {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final void a(int i) {
        this.a.j.postDelayed(new f(this, i), 1000);
    }

    public final void a() {
        this.a.j.postDelayed(new g(this), 1000);
    }
}
