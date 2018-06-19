package com.xunlei.downloadprovider.homepage.recommend;

import com.xunlei.downloadprovider.homepage.recommend.feed.p;

/* compiled from: SummaryMoviesFeedView */
final class h implements p {
    final /* synthetic */ b a;

    h(b bVar) {
        this.a = bVar;
    }

    public final void a(int i) {
        this.a.j.postDelayed(new i(this, i), 1000);
    }

    public final void a() {
        this.a.j.postDelayed(new j(this), 1000);
    }
}
