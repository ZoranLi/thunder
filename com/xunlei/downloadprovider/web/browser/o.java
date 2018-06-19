package com.xunlei.downloadprovider.web.browser;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: BrowserActivity */
final class o extends WebChromeClient {
    final /* synthetic */ BrowserActivity a;

    o(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void onProgressChanged(WebView webView, int i) {
        webView = this.a.p;
        if (webView.a != null) {
            webView.a.setProgress(i);
        }
    }

    public final void onReceivedTitle(WebView webView, String str) {
        String str2 = BrowserActivity.a;
        this.a.p.a(str);
        this.a.D = str;
        this.a.w = webView.getUrl();
        this.a.v = str;
        BrowserActivity.a(this.a, webView.getUrl(), str);
        BrowserActivity.c(this.a);
    }

    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        super.onReceivedIcon(webView, bitmap);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }
}
