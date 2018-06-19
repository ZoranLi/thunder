package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import java.util.HashMap;

/* compiled from: SpeedCache */
public final class f {
    private static long a = 1048576;
    private static HashMap<String, Long> b = new HashMap();

    public static void a() {
    }

    public static void a(long j) {
        a = j;
    }

    public static boolean b(long j) {
        return j >= a ? 1 : 0;
    }
}
