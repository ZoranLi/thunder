package com.qiniu.android.a;

import com.qiniu.android.d.c;

/* compiled from: Config */
public final class a {
    public static boolean a = true;
    public static boolean b = true;
    public static String c = null;
    public static int d = 2097152;
    public static int e = 4096;
    public static int f = 10;

    static {
        try {
            c = c.a().getCacheDir().getAbsolutePath();
        } catch (Throwable th) {
            th.fillInStackTrace();
        }
    }
}
