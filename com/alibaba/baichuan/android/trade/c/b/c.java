package com.alibaba.baichuan.android.trade.c.b;

import android.annotation.TargetApi;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import com.alibaba.baichuan.android.a.f;
import com.alibaba.baichuan.android.a.g;
import com.alibaba.baichuan.android.a.h;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.ui.activity.a;

public class c extends WebChromeClient {
    private g a;
    private boolean b;

    public c(g gVar, boolean z) {
        this.a = gVar;
        this.b = z;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        if (message == null || !message.startsWith("wvNativeCallback")) {
            return super.onConsoleMessage(consoleMessage);
        }
        String substring = message.substring(message.indexOf("/") + 1);
        int indexOf = substring.indexOf("/");
        String substring2 = substring.substring(0, indexOf);
        substring = substring.substring(indexOf + 1);
        ValueCallback a = f.a(substring2);
        if (a != null) {
            a.onReceiveValue(substring);
            f.b(substring2);
        }
        return true;
    }

    @TargetApi(5)
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        if (j2 < 20971520) {
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

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (!this.b && webView != null && (webView.getContext() instanceof a)) {
            a aVar = (a) webView.getContext();
            if (aVar.d) {
                aVar.c.setText(str);
            }
        }
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null || str3.equals("bc_hybrid:") == null) {
            return false;
        }
        str = com.alibaba.baichuan.android.a.a.a();
        str3 = this.a;
        AlibcContext.b();
        if (str.a) {
            str2 = com.alibaba.baichuan.android.a.a.a(str2);
            if (str2 == null) {
                AlibcContext.b();
            } else {
                str2.a = str3;
                new h(str, str2, str3.a().getUrl()).execute(new Void[0]);
            }
        } else {
            AlibcContext.b();
        }
        jsPromptResult.confirm("");
        return true;
    }
}
