package com.xunlei.downloadprovider.ad.common.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: WebViewADActivity */
final class e extends WebViewClient {
    final /* synthetic */ WebViewADActivity a;

    e(WebViewADActivity webViewADActivity) {
        this.a = webViewADActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!a(str)) {
            if (super.shouldOverrideUrlLoading(webView, str) == null) {
                return null;
            }
        }
        return true;
    }

    private boolean a(String str) {
        try {
            boolean b = this.a.j.b(str);
            WebViewADActivity.i;
            StringBuilder stringBuilder = new StringBuilder("url: ");
            stringBuilder.append(str);
            stringBuilder.append(" shouldOverrideUrlLoadingByApp: ");
            stringBuilder.append(b);
            return b;
        } catch (String str2) {
            str2.printStackTrace();
            WebViewADActivity.i;
            return true;
        }
    }
}
