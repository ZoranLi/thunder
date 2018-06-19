package com.xunlei.downloadprovider.homepage.recommend;

import com.xunlei.downloadprovider.homepage.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.t;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter.RefreshType;

/* compiled from: SummaryMoviesFeedView */
final class n implements a {
    final /* synthetic */ b a;

    public final int d() {
        return 30;
    }

    n(b bVar) {
        this.a = bVar;
    }

    public final void a() {
        this.a.m = RefreshType.auto_pull;
        this.a.a();
    }

    public final long b() {
        return t.a().a.getLong("SummaryMovieLastRefreshTime", 0);
    }

    public final void c() {
        t a = t.a();
        a.a.edit().putLong("SummaryMovieLastRefreshTime", System.currentTimeMillis()).apply();
    }
}
