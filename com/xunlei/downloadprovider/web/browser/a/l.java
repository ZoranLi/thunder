package com.xunlei.downloadprovider.web.browser.a;

import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebView;

/* compiled from: XLWebViewCore */
final class l extends f {
    final /* synthetic */ i b;

    l(i iVar) {
        this.b = iVar;
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!this.b.j().a) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        jsResult.cancel();
        webView = new StringBuilder("[AdBlock] block onJsAlert: ");
        webView.append(str);
        webView.append(" Message: ");
        webView.append(str2);
        return true;
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!this.b.j().a) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        jsResult.cancel();
        webView = new StringBuilder("[AdBlock] block onJsConfirm: ");
        webView.append(str);
        webView.append(" Message: ");
        webView.append(str2);
        return true;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (!this.b.j().a) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        jsPromptResult.cancel();
        webView = new StringBuilder("[AdBlock] block onJsPrompt: ");
        webView.append(str);
        webView.append(" Message: ");
        webView.append(str2);
        return true;
    }
}
