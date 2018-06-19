package com.handmark.pulltorefresh.library;

/* compiled from: PullToRefreshBase */
final class f implements f {
    final /* synthetic */ PullToRefreshBase a;

    f(PullToRefreshBase pullToRefreshBase) {
        this.a = pullToRefreshBase;
    }

    public final void a() {
        this.a.callRefreshListener();
    }
}
