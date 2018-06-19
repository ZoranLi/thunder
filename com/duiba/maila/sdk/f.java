package com.duiba.maila.sdk;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class f extends WebChromeClient {
    final /* synthetic */ MailaActivityInSdk a;

    f(MailaActivityInSdk mailaActivityInSdk) {
        this.a = mailaActivityInSdk;
    }

    public final void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i == 100) {
            this.a.m.setVisibility(8);
            return;
        }
        this.a.m.setVisibility(0);
        this.a.m.setProgress(i);
    }
}
