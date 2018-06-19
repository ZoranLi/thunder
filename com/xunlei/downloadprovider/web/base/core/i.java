package com.xunlei.downloadprovider.web.base.core;

import com.xunlei.downloadprovider.member.login.b.e.e;

/* compiled from: DefaultJsInterface */
final class i implements e {
    final /* synthetic */ String a;
    final /* synthetic */ DefaultJsInterface b;

    i(DefaultJsInterface defaultJsInterface, String str) {
        this.b = defaultJsInterface;
        this.a = str;
    }

    public final void a() {
        this.b.callback(this.a, null);
    }
}
