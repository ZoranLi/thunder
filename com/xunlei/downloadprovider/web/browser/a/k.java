package com.xunlei.downloadprovider.web.browser.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;

/* compiled from: XLWebViewCore */
final class k extends h {
    protected int c = null;
    final /* synthetic */ i d;

    k(i iVar) {
        this.d = iVar;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z = false;
        boolean z2;
        if (this.c > 1) {
            StringBuilder stringBuilder = new StringBuilder("WebPage Redirection: ");
            stringBuilder.append(str);
            stringBuilder.append(" RefUrl: ");
            stringBuilder.append(webView.getUrl());
            z2 = true;
        } else {
            z2 = false;
        }
        i iVar = this.d;
        String url = webView.getUrl();
        if (iVar.a != null && iVar.a.a(str, url)) {
            z = true;
        }
        if (!z || r0 || this.d.g) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        stringBuilder = new StringBuilder("[AdBlock] block shouldOverrideUrlLoading: ");
        stringBuilder.append(str);
        stringBuilder.append(" RefUrl: ");
        stringBuilder.append(webView.getUrl());
        return true;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.d.a(true);
        this.c++;
        super.onPageStarted(webView, str, bitmap);
    }

    public final void onPageFinished(WebView webView, String str) {
        this.d.a(false);
        this.c = 0;
        this.d.g = false;
        if (this.d.a != null) {
            this.d.a.a(webView);
        }
        super.onPageFinished(webView, str);
    }

    @TargetApi(21)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.d.a != null) {
            WebResourceResponse a = this.d.a.a(webResourceRequest.getUrl().toString());
            if (a != null) {
                return a;
            }
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (this.d.a != null) {
            WebResourceResponse a = this.d.a.a(str);
            if (a != null) {
                return a;
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
