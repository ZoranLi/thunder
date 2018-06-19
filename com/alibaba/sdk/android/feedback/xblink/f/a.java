package com.alibaba.sdk.android.feedback.xblink.f;

import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

public abstract class a {
    protected Context a;
    protected XBHybridWebView b;
    protected boolean c = true;

    public void a() {
        this.c = false;
        this.a = null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(Context context, XBHybridWebView xBHybridWebView) {
        this.a = context;
        this.b = xBHybridWebView;
    }

    public abstract boolean a(String str, String str2, b bVar);

    public void b() {
        this.c = false;
    }

    public void c() {
        this.c = true;
    }
}
