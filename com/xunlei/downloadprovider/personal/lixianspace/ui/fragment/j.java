package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;

/* compiled from: PullToRefreshWebFragment */
final class j implements e<CustomWebView> {
    final /* synthetic */ PullToRefreshWebFragment a;

    public final void onPullUpToRefresh(PullToRefreshBase<CustomWebView> pullToRefreshBase) {
    }

    j(PullToRefreshWebFragment pullToRefreshWebFragment) {
        this.a = pullToRefreshWebFragment;
    }

    public final void onPullDownToRefresh(PullToRefreshBase<CustomWebView> pullToRefreshBase) {
        this.a.a();
    }
}
