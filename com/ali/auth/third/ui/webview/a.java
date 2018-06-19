package com.ali.auth.third.ui.webview;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class a extends WebViewClient {
    @TargetApi(14)
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
            return;
        }
        if (VERSION.SDK_INT >= 14 && sslErrorHandler != null && sslError != null && sslError.getPrimaryError() <= 4) {
            sslError.getUrl();
        }
        if (sslErrorHandler != null) {
            sslErrorHandler.cancel();
        }
    }
}
