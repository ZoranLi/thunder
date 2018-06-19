package com.alibaba.sdk.android.feedback.xblink.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.SystemClock;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.sdk.android.feedback.xblink.a.d;
import com.alibaba.sdk.android.feedback.xblink.b.c;
import com.alibaba.sdk.android.feedback.xblink.e.a;
import com.alibaba.sdk.android.feedback.xblink.f.h;
import com.alibaba.sdk.android.feedback.xblink.i.g;

public class HybridWebViewClient extends WebViewClient {
    private static final String TAG = "HybridWebViewClient";
    protected String currentUrl = null;
    private boolean enableTakeDownload = true;
    protected a filter = null;
    private boolean isAppcacheEnabled = false;
    protected Context mContext;
    private boolean mIsFirst;
    private long mStartPageTime;
    private i mWebViewErrorListener;
    private boolean sdcardChanged = false;

    public HybridWebViewClient(Context context) {
        this.mContext = context;
    }

    private d doubleDownResponse(String str, String str2) {
        return null;
    }

    private d wrapperResponse(WebView webView, String str, String str2) {
        return null;
    }

    public void enableTakeDownload(boolean z) {
        this.enableTakeDownload = z;
    }

    public a getUrlFilter() {
        return this.filter;
    }

    public void onPageFinished(WebView webView, String str) {
        if (g.a()) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("Page finish: ");
            stringBuilder.append(str);
            g.d(str2, stringBuilder.toString());
        }
        ((XBHybridWebView) webView).onMessage(401, null);
        h.a().a(webView, str);
        if (this.mIsFirst) {
            this.mIsFirst = false;
            SystemClock.elapsedRealtime();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (g.a()) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("Page start: ");
            stringBuilder.append(str);
            g.d(str2, stringBuilder.toString());
        }
        this.mStartPageTime = SystemClock.elapsedRealtime();
        this.mIsFirst = true;
        this.isAppcacheEnabled = false;
        this.currentUrl = str;
        ((XBHybridWebView) webView).onMessage(400, null);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        if (g.a()) {
            str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder("Receive error, code: ");
            stringBuilder.append(i);
            stringBuilder.append("; desc: ");
            stringBuilder.append(str);
            stringBuilder.append("; url: ");
            stringBuilder.append(str2);
            g.d(str3, stringBuilder.toString());
        }
        str3 = webView.getUrl();
        if (str3 == null || str3.equals(str2)) {
            ((XBHybridWebView) webView).onMessage(402, str2);
        }
        if (i != -2 && c.c) {
            StringBuilder stringBuilder2 = new StringBuilder("4.5.1|");
            stringBuilder2.append(str);
            stringBuilder2.append("|");
            stringBuilder2.append(str2);
        }
        if (this.mWebViewErrorListener != null) {
            this.mWebViewErrorListener.onReceivedError();
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (g.a() && sslError != null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("Receive ssl error: ");
            stringBuilder.append(sslError.getPrimaryError());
            g.e(str, stringBuilder.toString());
        }
        sslErrorHandler.cancel();
    }

    public void setUrlFilter(a aVar) {
        this.filter = aVar;
    }

    public void setWebViewErrorListener(i iVar) {
        this.mWebViewErrorListener = iVar;
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (g.a()) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder("shouldOverrideUrlLoading: ");
            stringBuilder.append(str);
            g.d(str2, stringBuilder.toString());
        }
        return false;
    }
}
