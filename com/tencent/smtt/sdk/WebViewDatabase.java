package com.tencent.smtt.sdk;

import android.content.Context;

public class WebViewDatabase {
    private static WebViewDatabase a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            if (a == null) {
                a = new WebViewDatabase(context);
            }
            webViewDatabase = a;
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    public void clearFormData() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        } else {
            b.d().g(this.b);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        } else {
            b.d().e(this.b);
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        } else {
            b.d().c(this.b);
        }
    }

    public boolean hasFormData() {
        bk b = bk.b();
        return (b == null || !b.c()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasFormData() : b.d().f(this.b);
    }

    public boolean hasHttpAuthUsernamePassword() {
        bk b = bk.b();
        return (b == null || !b.c()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword() : b.d().d(this.b);
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        bk b = bk.b();
        return (b == null || !b.c()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword() : b.d().b(this.b);
    }
}
