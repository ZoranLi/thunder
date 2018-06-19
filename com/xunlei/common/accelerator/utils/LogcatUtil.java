package com.xunlei.common.accelerator.utils;

import com.xunlei.common.accelerator.config.Config;

public class LogcatUtil {
    private static boolean isDebug = Config.sIsDebuggable;

    public static void i(String str, String str2, Throwable th) {
        if (isDebug != null) {
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isDebug != null) {
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isDebug != null) {
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (isDebug != null) {
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isDebug != null) {
        }
    }

    public static void L(boolean z) {
        isDebug = z;
    }
}
