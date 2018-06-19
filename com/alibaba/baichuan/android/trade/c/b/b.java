package com.alibaba.baichuan.android.trade.c.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;

public final class b extends f {
    private WeakReference a;

    public b(WebViewClient webViewClient, d dVar) {
        super(dVar);
        this.a = new WeakReference(webViewClient);
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).doUpdateVisitedHistory(webView, str, z);
        }
    }

    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onFormResubmission(webView, message, message2);
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onLoadResource(webView, str);
        }
    }

    public final void onPageCommitVisible(WebView webView, String str) {
        if (VERSION.SDK_INT >= 23 && this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onPageCommitVisible(webView, str);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (!(this.a == null || this.a.get() == null)) {
            ((WebViewClient) this.a.get()).onPageFinished(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!(this.a == null || this.a.get() == null)) {
            ((WebViewClient) this.a.get()).onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21 && this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (!(this.a == null || this.a.get() == null)) {
            ((WebViewClient) this.a.get()).onReceivedError(webView, i, str, str2);
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (VERSION.SDK_INT >= 23 && this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 23 && this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onScaleChanged(webView, f, f2);
        }
    }

    @Deprecated
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onTooManyRedirects(webView, message, message2);
        }
    }

    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.a != null && this.a.get() != null) {
            ((WebViewClient) this.a.get()).onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return (VERSION.SDK_INT < 21 || this.a == null || this.a.get() == null) ? super.shouldInterceptRequest(webView, webResourceRequest) : ((WebViewClient) this.a.get()).shouldInterceptRequest(webView, webResourceRequest);
    }

    @Deprecated
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return (VERSION.SDK_INT <= 23 || this.a == null || this.a.get() == null) ? super.shouldInterceptRequest(webView, str) : ((WebViewClient) this.a.get()).shouldInterceptRequest(webView, str);
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return (this.a == null || this.a.get() == null) ? super.shouldOverrideKeyEvent(webView, keyEvent) : ((WebViewClient) this.a.get()).shouldOverrideKeyEvent(webView, keyEvent);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean shouldOverrideUrlLoading = (this.a == null || this.a.get() == null) ? false : ((WebViewClient) this.a.get()).shouldOverrideUrlLoading(webView, str);
        return !shouldOverrideUrlLoading ? super.shouldOverrideUrlLoading(webView, str) : true;
    }
}
