package com.xunlei.downloadprovider.homepage.recommend;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.homepage.recommend.feed.a;
import com.xunlei.downloadprovider.homepage.recommend.feed.b;

/* compiled from: SummaryMoviesFeedView */
final class l implements e<ListView> {
    final /* synthetic */ b a;

    l(b bVar) {
        this.a = bVar;
    }

    public final void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
        if (this.a.c) {
            XLThreadPool.execute(new b(a.a(), this.a.m, this.a.h));
            if (this.a.k != null) {
                this.a.k.onPullDownToRefresh(pullToRefreshBase);
            }
            return;
        }
        this.a.b.a = false;
        this.a.g.onRefreshComplete();
    }

    public final void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
        XLThreadPool.execute(new com.xunlei.downloadprovider.homepage.recommend.feed.e(a.a(), this.a.i, this.a.m));
        if (this.a.k != null) {
            this.a.k.onPullUpToRefresh(pullToRefreshBase);
        }
    }
}
