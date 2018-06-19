package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

class f implements OnClickListener {
    final /* synthetic */ JsResult a;
    final /* synthetic */ HybridWebChromeClient b;

    f(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.b = hybridWebChromeClient;
        this.a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.confirm();
    }
}
