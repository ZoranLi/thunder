package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: RedWebTitleBar */
final class n extends WebViewClient {
    final /* synthetic */ RedWebTitleBar a;

    n(RedWebTitleBar redWebTitleBar) {
        this.a = redWebTitleBar;
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.b.setVisibility(null);
    }
}
