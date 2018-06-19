package com.baidu.mobads.interfaces;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

public interface IXHybridAdRenderer extends IXAdContainer {
    String getJavaScriptBridge();

    void onPageFinished(WebView webView, String str);

    void onPageStarted(WebView webView, String str, Bitmap bitmap);

    void onReceivedError(WebView webView, int i, String str, String str2);

    void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void setCustomerWebView(WebView webView);

    boolean shouldOverrideUrlLoading(WebView webView, String str);
}
