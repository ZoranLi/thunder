package com.xunlei.downloadprovider.ad.common.browser;

import android.webkit.WebView;

/* compiled from: WebViewADActivity */
final class b implements com.xunlei.downloadprovider.web.base.core.CustomWebView.b {
    final /* synthetic */ WebViewADActivity a;

    public final void a() {
    }

    b(WebViewADActivity webViewADActivity) {
        this.a = webViewADActivity;
    }

    public final void a(WebView webView) {
        webView.getSettings().setBlockNetworkImage(false);
    }
}
