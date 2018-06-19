package com.xunlei.downloadprovider.web.base.core;

import android.os.Build.VERSION;

/* compiled from: CustomWebView */
final class e implements Runnable {
    final /* synthetic */ CustomWebView a;

    e(CustomWebView customWebView) {
        this.a = customWebView;
    }

    public final void run() {
        if (VERSION.SDK_INT < 19 || this.a.isAttachedToWindow()) {
            this.a.k();
        }
    }
}
