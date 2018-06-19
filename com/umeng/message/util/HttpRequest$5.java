package com.umeng.message.util;

import java.security.PrivilegedAction;

final class HttpRequest$5 implements PrivilegedAction<String> {
    final /* synthetic */ String a;

    HttpRequest$5(String str) {
        this.a = str;
    }

    public final /* synthetic */ Object run() {
        return a();
    }

    public final String a() {
        return System.clearProperty(this.a);
    }
}
