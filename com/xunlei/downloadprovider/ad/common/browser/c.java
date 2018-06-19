package com.xunlei.downloadprovider.ad.common.browser;

import com.xunlei.downloadprovider.web.base.core.CustomWebView.a;

/* compiled from: WebViewADActivity */
final class c implements a {
    final /* synthetic */ WebViewADActivity a;

    c(WebViewADActivity webViewADActivity) {
        this.a = webViewADActivity;
    }

    public final void a(String str) {
        if (!a.c(str)) {
            WebViewADActivity.a(str, this.a.k);
        }
    }

    public final void a(String str, int i) {
        if (!a.c(str)) {
            WebViewADActivity.a(str, this.a.k, i);
        }
    }
}
