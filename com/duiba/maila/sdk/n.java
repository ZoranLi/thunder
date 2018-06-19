package com.duiba.maila.sdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class n extends WebChromeClient {
    final /* synthetic */ ViewCore a;

    n(ViewCore viewCore) {
        this.a = viewCore;
    }

    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }
}
