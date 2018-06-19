package com.tencent.bugly.crashreport;

import com.tencent.bugly.b;
import com.tencent.bugly.proguard.ao;

/* compiled from: BUGLY */
public class BuglyLog {
    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = b.c;
        ao.a("V", str, str2);
    }

    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = b.c;
        ao.a("D", str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = b.c;
        ao.a("I", str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = b.c;
        ao.a("W", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z = b.c;
        ao.a("E", str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        str2 = b.c;
        ao.a("E", str, th);
    }

    public static void setCache(int i) {
        ao.a(i);
    }
}
