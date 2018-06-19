package com.handmark.pulltorefresh.library;

/* compiled from: PullToRefreshBase */
final class g implements f {
    final /* synthetic */ PullToRefreshBase a;

    g(PullToRefreshBase pullToRefreshBase) {
        this.a = pullToRefreshBase;
    }

    public final void a() {
        this.a.callRefreshListener();
    }
}
