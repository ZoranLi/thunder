package com.igexin.push.core;

import com.igexin.push.config.l;
import com.igexin.sdk.aidl.a;

public class o {
    private static String a = l.a;
    private static a b;

    public static a a() {
        if (b == null) {
            b = new p();
        }
        return b;
    }
}
