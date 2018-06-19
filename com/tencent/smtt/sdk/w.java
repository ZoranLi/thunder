package com.tencent.smtt.sdk;

import android.os.Message;
import android.webkit.WebView;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class w implements Runnable {
    final /* synthetic */ WebViewTransport a;
    final /* synthetic */ Message b;
    final /* synthetic */ SystemWebChromeClient c;

    w(SystemWebChromeClient systemWebChromeClient, WebViewTransport webViewTransport, Message message) {
        this.c = systemWebChromeClient;
        this.a = webViewTransport;
        this.b = message;
    }

    public void run() {
        WebView webView = this.a.getWebView();
        if (webView != null) {
            ((WebView.WebViewTransport) this.b.obj).setWebView(webView.a());
        }
        this.b.sendToTarget();
    }
}
