package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class o implements Runnable {
    final /* synthetic */ WebViewTransport a;
    final /* synthetic */ Message b;
    final /* synthetic */ n c;

    o(n nVar, WebViewTransport webViewTransport, Message message) {
        this.c = nVar;
        this.a = webViewTransport;
        this.b = message;
    }

    public void run() {
        WebView webView = this.a.getWebView();
        if (webView != null) {
            ((IX5WebViewBase.WebViewTransport) this.b.obj).setWebView(webView.b());
        }
        this.b.sendToTarget();
    }
}
