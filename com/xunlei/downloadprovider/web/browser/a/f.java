package com.xunlei.downloadprovider.web.browser.a;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: XLWebChromeClient */
public class f extends WebChromeClient {
    public WebChromeClient a;

    public void onProgressChanged(WebView webView, int i) {
        if (this.a != null) {
            this.a.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (this.a != null) {
            this.a.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.a != null) {
            this.a.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (this.a != null) {
            return this.a.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.a != null) {
            return this.a.onJsAlert(webView, str, str2, jsResult);
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.a != null) {
            return this.a.onJsConfirm(webView, str, str2, jsResult);
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (this.a != null) {
            return this.a.onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return super.onJsBeforeUnload(webView, str, str2, jsResult);
    }
}
