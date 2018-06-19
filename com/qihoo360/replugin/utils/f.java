package com.qihoo360.replugin.utils;

/* compiled from: Validate */
public final class f {
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
