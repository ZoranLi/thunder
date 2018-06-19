package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.proxy.X5ProxyWebChromeClient;
import com.tencent.smtt.sdk.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class n extends X5ProxyWebChromeClient {
    private WebView a;
    private WebChromeClient b;

    class a implements QuotaUpdater {
        com.tencent.smtt.export.external.interfaces.QuotaUpdater a;
        final /* synthetic */ n b;

        a(n nVar, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
            this.b = nVar;
            this.a = quotaUpdater;
        }

        public void updateQuota(long j) {
            this.a.updateQuota(j);
        }
    }

    public n(IX5WebChromeClient iX5WebChromeClient, WebView webView, WebChromeClient webChromeClient) {
        super(iX5WebChromeClient);
        this.a = webView;
        this.b = webChromeClient;
    }

    public Bitmap getDefaultVideoPoster() {
        return this.b.getDefaultVideoPoster();
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        this.a.a(iX5WebViewBase);
        this.b.onCloseWindow(this.a);
    }

    public void onConsoleMessage(String str, int i, String str2) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.b.onConsoleMessage(consoleMessage);
    }

    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message) {
        WebView webView = this.a;
        webView.getClass();
        WebViewTransport webViewTransport = new WebViewTransport(webView);
        message = Message.obtain(message.getTarget(), new o(this, webViewTransport, message));
        message.obj = webViewTransport;
        return this.b.onCreateWindow(this.a, z, z2, message);
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, new a(this, quotaUpdater));
    }

    public void onGeolocationPermissionsHidePrompt() {
        this.b.onGeolocationPermissionsHidePrompt();
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        this.b.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
    }

    public void onHideCustomView() {
        this.b.onHideCustomView();
    }

    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsAlert(this.a, str, str2, jsResult);
    }

    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsBeforeUnload(this.a, str, str2, jsResult);
    }

    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsConfirm(this.a, str, str2, jsResult);
    }

    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        this.a.a(iX5WebViewBase);
        return this.b.onJsPrompt(this.a, str, str2, str3, jsPromptResult);
    }

    public boolean onJsTimeout() {
        return this.b.onJsTimeout();
    }

    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i) {
        this.a.a(iX5WebViewBase);
        this.b.onProgressChanged(this.a, i);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.export.external.interfaces.QuotaUpdater quotaUpdater) {
        this.b.onReachedMaxAppCacheSize(j, j2, new a(this, quotaUpdater));
    }

    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedIcon(this.a, bitmap);
    }

    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTitle(this.a, str);
    }

    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.a.a(iX5WebViewBase);
        this.b.onReceivedTouchIconUrl(this.a, str, z);
    }

    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        this.a.a(iX5WebViewBase);
        this.b.onRequestFocus(this.a);
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, i, customViewCallback);
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        this.b.onShowCustomView(view, customViewCallback);
    }

    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        ValueCallback qVar = new q(this, valueCallback);
        WebChromeClient.FileChooserParams rVar = new r(this, fileChooserParams);
        this.a.a(iX5WebViewBase);
        return this.b.onShowFileChooser(this.a, qVar, rVar);
    }

    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        this.b.openFileChooser(new p(this, valueCallback), str, str2);
    }
}
