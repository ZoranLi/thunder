package com.duiba.maila.sdk;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class o extends WebViewClient {
    final /* synthetic */ ViewCore a;

    o(ViewCore viewCore) {
        this.a = viewCore;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (webView.getProgress() <= 20) {
            this.a.b = null;
            this.a.d.setVisibility(8);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView.getProgress() == 100 && this.a.b == null) {
            this.a.d.setVisibility(8);
            this.a.a.setVisibility(null);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder stringBuilder;
        if (str.startsWith("weixin://") == null) {
            if (str.startsWith("tbopen://") == null) {
                if (str.contains("//m.maila88.com/index?") != null) {
                    return false;
                }
                if (str.contains("mlnewopen") != null) {
                    try {
                        webView = str.replace("mlnewopen", "none");
                        try {
                            str = new StringBuilder();
                            str.append(this.a.c.getPackageName());
                            str.append(".maila.VIEW");
                            this.a.c.startActivity(new Intent(str.toString(), Uri.parse(webView)));
                        } catch (Exception e) {
                            str = e;
                            stringBuilder = new StringBuilder("无法打开该链接");
                            stringBuilder.append(webView);
                            stringBuilder.append("               ");
                            stringBuilder.append(str.getMessage());
                            return true;
                        }
                    } catch (WebView webView2) {
                        String str2 = str;
                        str = webView2;
                        webView2 = str2;
                        stringBuilder = new StringBuilder("无法打开该链接");
                        stringBuilder.append(webView2);
                        stringBuilder.append("               ");
                        stringBuilder.append(str.getMessage());
                        return true;
                    }
                    return true;
                } else if (str.contains("/special/index") == null) {
                    return false;
                } else {
                    try {
                        webView2 = new StringBuilder();
                        webView2.append(this.a.c.getPackageName());
                        webView2.append(".maila.VIEW");
                        this.a.c.startActivity(new Intent(webView2.toString(), Uri.parse(str)));
                    } catch (WebView webView22) {
                        stringBuilder = new StringBuilder("无法打开该链接");
                        stringBuilder.append(str);
                        stringBuilder.append("               ");
                        stringBuilder.append(webView22.getMessage());
                    }
                    return true;
                }
            }
        }
        ViewCore.a(this.a, str);
        return true;
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    @TargetApi(23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.a.b = true;
        this.a.a();
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.a.b = true;
        this.a.a();
    }
}
