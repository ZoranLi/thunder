package com.duiba.maila.sdk;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class g extends WebViewClient {
    final /* synthetic */ MailaActivityInSdk a;

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    g(MailaActivityInSdk mailaActivityInSdk) {
        this.a = mailaActivityInSdk;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.e = str;
        if (webView.getProgress() <= 20) {
            this.a.c = null;
            this.a.l.setVisibility(8);
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (str.equals(this.a.e) == null) {
            this.a.a(str, this.a.a);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (webView.getProgress() == 100) {
            this.a.a(str, this.a.a);
            if (this.a.c == null) {
                this.a.l.setVisibility(8);
                this.a.a.setVisibility(0);
            }
        }
        if (!(this.a.a == null || this.a.a.getTitle() == null || this.a.a.getTitle().length() <= null)) {
            if (this.a.a.getTitle().length() >= 9) {
                webView = this.a.h;
                str = new StringBuilder();
                str.append(this.a.a.getTitle().substring(0, 7));
                str.append("...");
                webView.setText(str.toString());
                return;
            }
            this.a.h.setText(this.a.a.getTitle());
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.a.c = true;
        this.a.a();
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.c = true;
        this.a.a();
    }
}
