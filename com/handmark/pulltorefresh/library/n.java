package com.handmark.pulltorefresh.library;

import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.d;

/* compiled from: PullToRefreshWebView */
final class n implements d<WebView> {
    n() {
    }

    public final void a(PullToRefreshBase<WebView> pullToRefreshBase) {
        ((WebView) pullToRefreshBase.getRefreshableView()).reload();
    }
}
