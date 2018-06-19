package com.xunlei.downloadprovider.web.browser.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* compiled from: XLWebViewClient */
public class h extends WebViewClient {
    public WebViewClient b;

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.b != null) {
            return this.b.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.b != null) {
            this.b.onPageStarted(webView, str, bitmap);
        } else {
            super.onPageStarted(webView, str, bitmap);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        if (this.b != null) {
            this.b.onPageFinished(webView, str);
        } else {
            super.onPageFinished(webView, str);
        }
    }

    public void onLoadResource(WebView webView, String str) {
        if (this.b != null) {
            this.b.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.b != null) {
            return this.b.shouldInterceptRequest(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.b != null) {
            return this.b.shouldInterceptRequest(webView, str);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.b != null) {
            this.b.onReceivedError(webView, i, str, str2);
        } else {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.b != null) {
            this.b.onReceivedError(webView, webResourceRequest, webResourceError);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        if (this.b != null) {
            this.b.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (this.b != null) {
            this.b.doUpdateVisitedHistory(webView, str, z);
        } else {
            super.doUpdateVisitedHistory(webView, str, z);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.b != null) {
            this.b.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (this.b != null) {
            this.b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.b != null) {
            return this.b.shouldOverrideKeyEvent(webView, keyEvent);
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (this.b != null) {
            this.b.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        if (this.b != null) {
            this.b.onScaleChanged(webView, f, f2);
        } else {
            super.onScaleChanged(webView, f, f2);
        }
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (this.b != null) {
            this.b.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }
}
