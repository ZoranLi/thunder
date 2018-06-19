package com.xunlei.downloadprovider.web.base;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;

/* compiled from: CustomWebViewActivity */
final class b implements e<CustomWebView> {
    final /* synthetic */ CustomWebViewActivity a;

    public final void onPullUpToRefresh(PullToRefreshBase<CustomWebView> pullToRefreshBase) {
    }

    b(CustomWebViewActivity customWebViewActivity) {
        this.a = customWebViewActivity;
    }

    public final void onPullDownToRefresh(PullToRefreshBase<CustomWebView> pullToRefreshBase) {
        this.a.f_();
    }
}
