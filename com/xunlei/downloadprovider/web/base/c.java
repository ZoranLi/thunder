package com.xunlei.downloadprovider.web.base;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: CustomWebViewActivity */
final class c extends WebChromeClient {
    final /* synthetic */ CustomWebViewActivity a;

    c(CustomWebViewActivity customWebViewActivity) {
        this.a = customWebViewActivity;
    }

    public final void onReceivedTitle(WebView webView, String str) {
        if (!(this.a.a == null || TextUtils.isEmpty(this.a.a.getTitleText()) == null || TextUtils.isEmpty(str) != null)) {
            this.a.a.setTitleText(str);
        }
    }
}
