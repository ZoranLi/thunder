package com.xunlei.downloadprovider.web.browser.a;

import android.os.Build.VERSION;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.xunlei.downloadprovider.web.browser.a.a.b;

/* compiled from: XLWebViewCore */
public final class i {
    com.xunlei.downloadprovider.web.browser.a.a.a a = b.a().b();
    protected WebView b;
    protected final g c = new j(this);
    protected final h d = new k(this);
    protected final f e = new l(this);
    protected boolean f = false;
    public boolean g = false;
    private a h = a.a();
    private a i;

    /* compiled from: XLWebViewCore */
    public static final class a {
        boolean a = false;
    }

    public final void a() {
        if (this.b != null) {
            this.b.stopLoading();
        }
    }

    public final boolean c() {
        return this.b != null ? this.b.canGoBack() : false;
    }

    public final boolean e() {
        return this.b != null ? this.b.canGoForward() : false;
    }

    public final void a(String str, ValueCallback<String> valueCallback) {
        if (this.b != null && VERSION.SDK_INT >= 19) {
            this.b.evaluateJavascript(str, valueCallback);
        }
    }

    public final String g() {
        return this.b != null ? this.b.getUrl() : null;
    }

    public final WebBackForwardList h() {
        return this.b != null ? this.b.copyBackForwardList() : null;
    }

    public final void i() {
        if (this.b != null) {
            this.b.requestFocus();
        }
    }

    public final a j() {
        if (this.i == null) {
            this.i = new a();
        }
        return this.i;
    }

    public final void a(WebView webView) {
        this.b = webView;
        if (webView != null && webView != null) {
            webView.setWebChromeClient(this.e);
            webView.setWebViewClient(this.d);
            webView.setDownloadListener(this.c);
        }
    }

    public final WebView k() {
        WebView webView = this.b;
        this.b = null;
        return webView;
    }

    public final void a(WebViewClient webViewClient) {
        this.d.b = webViewClient;
    }

    public final void a(DownloadListener downloadListener) {
        this.c.a = downloadListener;
    }

    public final void a(WebChromeClient webChromeClient) {
        this.e.a = webChromeClient;
    }

    protected final void a(boolean z) {
        this.f = z;
    }

    public final void b() {
        this.g = true;
        if (this.b != null) {
            this.b.reload();
        }
    }

    public final void d() {
        this.g = true;
        if (this.b != null) {
            this.b.goBack();
        }
    }

    public final void f() {
        this.g = true;
        if (this.b != null) {
            this.b.goForward();
        }
    }

    public final void a(String str) {
        this.g = true;
        if (this.b != null) {
            if (VERSION.SDK_INT < 19 || str == null || !str.startsWith("javascript:")) {
                this.b.loadUrl(str);
            } else {
                this.b.evaluateJavascript(str.substring(11), null);
            }
        }
    }
}
