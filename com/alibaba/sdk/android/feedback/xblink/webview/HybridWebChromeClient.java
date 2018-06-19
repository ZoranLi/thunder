package com.alibaba.sdk.android.feedback.xblink.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.alibaba.sdk.android.feedback.xblink.f.d;
import com.alibaba.sdk.android.feedback.xblink.i.g;

public class HybridWebChromeClient extends WebChromeClient {
    private static final long MAX_QUOTA = 20971520;
    private static final String TAG = "HybridWebChromeClient";
    protected Context mContext;

    public HybridWebChromeClient(Context context) {
        this.mContext = context;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (g.a()) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("onConsoleMessage:");
            stringBuilder.append(consoleMessage.message());
            stringBuilder.append(" at ");
            stringBuilder.append(consoleMessage.sourceId());
            stringBuilder.append(": ");
            stringBuilder.append(consoleMessage.lineNumber());
            g.c(str, stringBuilder.toString());
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @TargetApi(5)
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        if (j2 < MAX_QUOTA) {
            quotaUpdater.updateQuota(j2);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!(this.mContext instanceof Activity)) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        Builder builder = new Builder(this.mContext);
        builder.setMessage(str2);
        builder.setTitle("提示");
        builder.setCancelable(true);
        builder.setPositiveButton(17039370, new d(this, jsResult));
        builder.setOnCancelListener(new e(this, jsResult));
        builder.create();
        builder.show();
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!(this.mContext instanceof Activity)) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        Builder builder = new Builder(this.mContext);
        builder.setMessage(str2);
        builder.setTitle("提示");
        builder.setCancelable(true);
        builder.setPositiveButton(17039370, new f(this, jsResult));
        builder.setNegativeButton(17039360, new g(this, jsResult));
        builder.setOnCancelListener(new h(this, jsResult));
        builder.create();
        builder.show();
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (g.a()) {
            String str4 = TAG;
            StringBuilder stringBuilder = new StringBuilder("onJsPrompt: ");
            stringBuilder.append(str2);
            stringBuilder.append("; defaultValue: ");
            stringBuilder.append(str3);
            stringBuilder.append("; url: ");
            stringBuilder.append(str);
            g.c(str4, stringBuilder.toString());
        }
        if (str3 == null || !str3.equals("wv_hybrid:")) {
            return false;
        }
        d.a().a((XBHybridWebView) webView, str2);
        jsPromptResult.confirm("");
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }
}
