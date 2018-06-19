package com.alibaba.sdk.android.feedback.xblink.webview;

import android.view.View;
import android.view.View.OnClickListener;

class p implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ XBHybridWebView b;

    p(XBHybridWebView xBHybridWebView, String str) {
        this.b = xBHybridWebView;
        this.a = str;
    }

    public void onClick(View view) {
        StringBuilder stringBuilder = new StringBuilder("javascript:");
        stringBuilder.append(this.a);
        this.b.loadUrl(stringBuilder.toString());
    }
}
