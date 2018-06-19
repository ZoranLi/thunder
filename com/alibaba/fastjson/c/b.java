package com.alibaba.fastjson.c;

import java.security.PrivilegedAction;

/* compiled from: ASMClassLoader */
final class b implements PrivilegedAction<Object> {
    b() {
    }

    public final Object run() {
        return a.class.getProtectionDomain();
    }
}
