package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsResult;

class d implements OnClickListener {
    final /* synthetic */ JsResult a;
    final /* synthetic */ HybridWebChromeClient b;

    d(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.b = hybridWebChromeClient;
        this.a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.confirm();
    }
}
