package com.aplayer.aplayerandroid;

public class Log {
    private static boolean openLog = false;

    public static void setOpenLog(boolean z) {
        openLog = z;
    }

    public static int i(String str, String str2) {
        if (openLog) {
            return android.util.Log.i(str, str2);
        }
        return 1;
    }

    public static int i(String str, String str2, Throwable th) {
        if (openLog) {
            return android.util.Log.i(str, str2, th);
        }
        return 1;
    }

    public static int e(String str, String str2) {
        if (openLog) {
            return android.util.Log.e(str, str2);
        }
        return 1;
    }

    public static int e(String str, String str2, Throwable th) {
        if (openLog) {
            return android.util.Log.e(str, str2, th);
        }
        return 1;
    }

    public static int v(String str, String str2) {
        if (openLog) {
            return android.util.Log.v(str, str2);
        }
        return 1;
    }

    public static int v(String str, String str2, Throwable th) {
        if (openLog) {
            return android.util.Log.v(str, str2, th);
        }
        return 1;
    }
}
