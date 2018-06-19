package com.umeng.message.util;

import java.security.PrivilegedAction;

final class HttpRequest$4 implements PrivilegedAction<String> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    HttpRequest$4(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final /* synthetic */ Object run() {
        return a();
    }

    public final String a() {
        return System.setProperty(this.a, this.b);
    }
}
