package com.xunlei.downloadprovider.homepage.recommend;

import android.view.ViewGroup;

/* compiled from: SummaryMoviesFeedView */
final class f implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ e b;

    f(e eVar, int i) {
        this.b = eVar;
        this.a = i;
    }

    public final void run() {
        b.a(this.b.a, false, true, this.a);
        if (this.b.a.l != null) {
            this.b.a.l.a((ViewGroup) this.b.a.g.getRefreshableView());
        }
    }
}
