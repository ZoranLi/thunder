package com.ali.auth.third.core;

import java.util.Collections;
import java.util.Map;

public final class a {
    private static final Map<String, String> a = Collections.singletonMap("$isv_scope$", "true");

    public static <T> T a(Class<T> cls) {
        return com.ali.auth.third.core.c.a.h.a((Class) cls, a);
    }
}
