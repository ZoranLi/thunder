package com.tencent.smtt.sdk;

import android.webkit.DownloadListener;
import com.tencent.smtt.sdk.a.d;

class bg implements DownloadListener {
    final /* synthetic */ DownloadListener a;
    final /* synthetic */ WebView b;

    bg(WebView webView, DownloadListener downloadListener) {
        this.b = webView;
        this.a = downloadListener;
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.a == null) {
            d.a(this.b.i, str, null, null);
        } else {
            this.a.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
