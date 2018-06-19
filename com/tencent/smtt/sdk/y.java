package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class y implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ SystemWebChromeClient b;

    y(SystemWebChromeClient systemWebChromeClient, ValueCallback valueCallback) {
        this.b = systemWebChromeClient;
        this.a = valueCallback;
    }

    public void a(Uri[] uriArr) {
        this.a.onReceiveValue(uriArr);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        a((Uri[]) obj);
    }
}
