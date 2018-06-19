package com.xunlei.analytics.c;

import java.util.TimeZone;

public class c {
    public static final int a = 86400;
    public static final long b = 86400000;

    private static long a(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static boolean a(long j, long j2) {
        long j3 = j - j2;
        return j3 < 86400000 && j3 > -86400000 && a(j) == a(j2);
    }
}
