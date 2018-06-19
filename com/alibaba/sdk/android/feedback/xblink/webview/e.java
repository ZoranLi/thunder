package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.webkit.JsResult;

class e implements OnCancelListener {
    final /* synthetic */ JsResult a;
    final /* synthetic */ HybridWebChromeClient b;

    e(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.b = hybridWebChromeClient;
        this.a = jsResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
