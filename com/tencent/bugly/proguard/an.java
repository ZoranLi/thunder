package com.tencent.bugly.proguard;

import java.util.Locale;

/* compiled from: BUGLY */
public class an {
    public static String a = "CrashReportInfo";
    public static String b = "CrashReport";
    public static boolean c = false;

    private static String f(String str, Object... objArr) {
        if (str == null) {
            return "null";
        }
        if (objArr != null) {
            if (objArr.length != 0) {
                return String.format(Locale.US, str, objArr);
            }
        }
        return str;
    }

    private static boolean a(int i, String str, Object... objArr) {
        if (!c) {
            return false;
        }
        f(str, objArr);
        if (i == 5) {
            return true;
        }
        switch (i) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default:
                return false;
        }
    }

    private static boolean a(int i, Throwable th) {
        if (c) {
            return a(i, ap.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        return a(0, String.format(Locale.US, "[%s] %s", new Object[]{cls.getSimpleName(), str}), objArr);
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean b(Class cls, String str, Object... objArr) {
        return a(1, String.format(Locale.US, "[%s] %s", new Object[]{cls.getSimpleName(), str}), objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean a(Throwable th) {
        return a(2, th);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean c(Class cls, String str, Object... objArr) {
        return a(3, String.format(Locale.US, "[%s] %s", new Object[]{cls.getSimpleName(), str}), objArr);
    }

    public static boolean b(Throwable th) {
        return a(3, th);
    }
}
