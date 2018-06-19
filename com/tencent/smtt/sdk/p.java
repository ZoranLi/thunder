package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.ValueCallback;

class p implements ValueCallback<Uri> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ n b;

    p(n nVar, ValueCallback valueCallback) {
        this.b = nVar;
        this.a = valueCallback;
    }

    public void a(Uri uri) {
        this.a.onReceiveValue(new Uri[]{uri});
    }

    public /* synthetic */ void onReceiveValue(Object obj) {
        a((Uri) obj);
    }
}
