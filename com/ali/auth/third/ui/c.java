package com.ali.auth.third.ui;

import android.webkit.WebView;

final class c extends com.ali.auth.third.ui.webview.c {
    final /* synthetic */ LoginWebViewActivity a;

    c(LoginWebViewActivity loginWebViewActivity) {
        this.a = loginWebViewActivity;
    }

    public final void onReceivedTitle(WebView webView, String str) {
        if (!this.a.g) {
            return;
        }
        if ((str == null || !str.contains("我喜欢")) && str != null) {
            this.a.e.setText(str);
        }
    }
}
