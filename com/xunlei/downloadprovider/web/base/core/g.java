package com.xunlei.downloadprovider.web.base.core;

import android.webkit.DownloadListener;

/* compiled from: CustomWebView */
final class g implements DownloadListener {
    final /* synthetic */ CustomWebView a;

    g(CustomWebView customWebView) {
        this.a = customWebView;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.a.b != null) {
            CustomWebView.a(this.a, str, "", this.a.b.getUrl(), this.a.d);
        }
    }
}
