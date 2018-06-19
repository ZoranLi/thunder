package com.xunlei.downloadprovider.homepage.choiceness.ui;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.a.j;
import com.xunlei.downloadprovider.homepage.choiceness.a.k;
import com.xunlei.downloadprovider.homepage.choiceness.a.n;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.b;

/* compiled from: HomeChoicenessFragment */
final class v implements b {
    final /* synthetic */ HomeChoicenessFragment a;

    v(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void a() {
        if (!this.a.m.d()) {
            this.a.n.a();
        }
        a g = this.a.h;
        ChoicenessReporter$RefreshType j = this.a.k;
        a.a wVar = new w(this);
        new StringBuilder("refreshDataFromServer--mMaxSortId=").append(g.b);
        if (g.a(wVar)) {
            j jVar = g.a;
            long j2 = g.b;
            long c = g.c();
            com.xunlei.downloadprovider.search.b.b bVar = new com.xunlei.downloadprovider.homepage.choiceness.a.b(g, j, wVar);
            f.a(BrothersApplication.getApplicationInstance()).a(ChoicenessReporter.a(j));
            XLThreadPool.execute(new k(jVar, j, j2, c, bVar));
        }
    }

    public final void b() {
        a g = this.a.h;
        ChoicenessReporter$RefreshType j = this.a.k;
        a.a xVar = new x(this);
        new StringBuilder("getNextPageData--mMinSortId=").append(g.c);
        if (g.a(xVar)) {
            j jVar = g.a;
            long j2 = g.c;
            long c = g.c();
            com.xunlei.downloadprovider.search.b.b cVar = new c(g, j, xVar);
            f.a(BrothersApplication.getApplicationInstance()).a(ChoicenessReporter.a(j));
            XLThreadPool.execute(new n(jVar, j, j2, c, cVar));
        }
    }
}
