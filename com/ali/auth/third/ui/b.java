package com.ali.auth.third.ui;

import android.net.Uri;
import android.webkit.WebView;
import com.ali.auth.third.ui.webview.TaeWebView;
import com.ali.auth.third.ui.webview.a;

final class b extends a {
    final /* synthetic */ LoginWebViewActivity a;

    b(LoginWebViewActivity loginWebViewActivity) {
        this.a = loginWebViewActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (this.a.j.a()) {
            new com.ali.auth.third.a.c.a(this.a.d).execute(new String[0]);
            return true;
        } else if (LoginWebViewActivity.a(str)) {
            return LoginWebViewActivity.a(this.a, parse);
        } else {
            if (webView instanceof TaeWebView) {
                ((TaeWebView) webView).loadUrl(str);
                return true;
            }
            webView.loadUrl(str);
            return true;
        }
    }
}
