package com.xunlei.downloadprovider.personal.settings;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: HelpActivity */
final class o extends WebViewClient {
    final /* synthetic */ HelpActivity a;

    o(HelpActivity helpActivity) {
        this.a = helpActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str != null) {
            try {
                webView.loadUrl(str);
            } catch (WebView webView2) {
                new StringBuilder("loadUrl error ").append(webView2.getMessage());
            }
        }
        return true;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        StringBuilder stringBuilder = new StringBuilder("loadUrl onPageStarted url:");
        stringBuilder.append(str);
        stringBuilder.append(" title:");
        stringBuilder.append(webView.getTitle());
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onPageFinished(WebView webView, String str) {
        StringBuilder stringBuilder = new StringBuilder("loadUrl onPageFinished url:");
        stringBuilder.append(str);
        stringBuilder.append(" title:");
        stringBuilder.append(webView.getTitle());
        this.a.a(webView);
        super.onPageFinished(webView, str);
    }
}
