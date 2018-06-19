package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

class bf implements FindListener {
    final /* synthetic */ IX5WebViewBase.FindListener a;
    final /* synthetic */ WebView b;

    bf(WebView webView, IX5WebViewBase.FindListener findListener) {
        this.b = webView;
        this.a = findListener;
    }

    public void onFindResultReceived(int i, int i2, boolean z) {
        this.a.onFindResultReceived(i, i2, z);
    }
}
