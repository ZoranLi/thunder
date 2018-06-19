package com.handmark.pulltorefresh.library;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: PullToRefreshWebView */
final class o extends WebChromeClient {
    final /* synthetic */ PullToRefreshWebView a;

    o(PullToRefreshWebView pullToRefreshWebView) {
        this.a = pullToRefreshWebView;
    }

    public final void onProgressChanged(WebView webView, int i) {
        if (i == 100) {
            this.a.onRefreshComplete();
        }
    }
}
