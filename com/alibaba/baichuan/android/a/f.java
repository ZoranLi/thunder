package com.alibaba.baichuan.android.a;

import android.webkit.ValueCallback;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private static ConcurrentHashMap a = new ConcurrentHashMap();

    public static ValueCallback a(String str) {
        return (ValueCallback) a.get(str);
    }

    public static void b(String str) {
        a.remove(str);
    }
}
