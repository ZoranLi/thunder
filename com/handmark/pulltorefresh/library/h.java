package com.handmark.pulltorefresh.library;

/* compiled from: PullToRefreshBase */
final class h implements Runnable {
    final /* synthetic */ PullToRefreshBase a;

    h(PullToRefreshBase pullToRefreshBase) {
        this.a = pullToRefreshBase;
    }

    public final void run() {
        this.a.requestLayout();
    }
}
