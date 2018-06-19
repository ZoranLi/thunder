package com.ali.auth.third.ui.webview;

import android.webkit.WebView;

final class f extends c {
    final /* synthetic */ BaseWebViewActivity a;

    f(BaseWebViewActivity baseWebViewActivity) {
        this.a = baseWebViewActivity;
    }

    public final void onReceivedTitle(WebView webView, String str) {
        if (this.a.g) {
            this.a.e.setText(str);
        }
    }
}
