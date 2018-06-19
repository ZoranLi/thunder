package com.handmark.pulltorefresh.library;

/* compiled from: PullToRefreshListView */
final class l implements Runnable {
    final /* synthetic */ PullToRefreshListView a;

    l(PullToRefreshListView pullToRefreshListView) {
        this.a = pullToRefreshListView;
    }

    public final void run() {
        this.a.headerRefreshingForce();
    }
}
