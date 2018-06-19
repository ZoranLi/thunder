package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class q implements ValueCallback<Uri[]> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ n b;

    q(n nVar, ValueCallback valueCallback) {
        this.b = nVar;
        this.a = valueCallback;
    }

    public void a(Uri[] uriArr) {
        this.a.onReceiveValue(uriArr);
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        a((Uri[]) obj);
    }
}
