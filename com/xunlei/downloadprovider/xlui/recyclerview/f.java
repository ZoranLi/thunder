package com.xunlei.downloadprovider.xlui.recyclerview;

/* compiled from: PullToRefreshHeaderView */
final class f implements Runnable {
    final /* synthetic */ PullToRefreshHeaderView a;

    f(PullToRefreshHeaderView pullToRefreshHeaderView) {
        this.a = pullToRefreshHeaderView;
    }

    public final void run() {
        this.a.setState(0);
    }
}
