package com.xunlei.analytics.b;

import android.text.TextUtils;

public class e {
    private static String a = "";
    private static long b = 0;
    private static long c = 5000;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = String.valueOf(System.currentTimeMillis());
        }
        return a;
    }

    public static void a(long j) {
        c = j;
    }

    public static void b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(a) || (b != 0 && (currentTimeMillis - b >= c || currentTimeMillis < b))) {
            a = String.valueOf(currentTimeMillis);
        }
        b = 0;
    }

    public static void c() {
        b = System.currentTimeMillis();
    }
}
