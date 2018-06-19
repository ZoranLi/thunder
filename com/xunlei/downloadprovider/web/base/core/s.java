package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.web.base.core.w.c;

/* compiled from: DefaultJsInterface */
final class s implements c {
    final /* synthetic */ String a;
    final /* synthetic */ DefaultJsInterface b;

    s(DefaultJsInterface defaultJsInterface, String str) {
        this.b = defaultJsInterface;
        this.a = str;
    }

    public final void a(int i, int i2, String str) {
        if (i == 0) {
            this.b.httpRequestCallback(this.a, true, 200, str);
        } else {
            this.b.httpRequestCallback(this.a, false, i2, "");
        }
    }
}
