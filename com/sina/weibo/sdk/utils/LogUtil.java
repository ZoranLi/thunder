package com.sina.weibo.sdk.utils;

import com.umeng.message.proguard.k;

public class LogUtil {
    public static boolean sIsLogEnable = false;

    public static void enableLog() {
        sIsLogEnable = true;
    }

    public static void disableLog() {
        sIsLogEnable = false;
    }

    public static void d(String str, String str2) {
        if (sIsLogEnable != null) {
            str = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.getFileName());
            stringBuilder.append(k.s);
            stringBuilder.append(str.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(str.getMethodName());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
        }
    }

    public static void i(String str, String str2) {
        if (sIsLogEnable != null) {
            str = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.getFileName());
            stringBuilder.append(k.s);
            stringBuilder.append(str.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(str.getMethodName());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
        }
    }

    public static void e(String str, String str2) {
        if (sIsLogEnable != null) {
            str = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.getFileName());
            stringBuilder.append(k.s);
            stringBuilder.append(str.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(str.getMethodName());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
        }
    }

    public static void w(String str, String str2) {
        if (sIsLogEnable != null) {
            str = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.getFileName());
            stringBuilder.append(k.s);
            stringBuilder.append(str.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(str.getMethodName());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
        }
    }

    public static void v(String str, String str2) {
        if (sIsLogEnable != null) {
            str = Thread.currentThread().getStackTrace()[3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.getFileName());
            stringBuilder.append(k.s);
            stringBuilder.append(str.getLineNumber());
            stringBuilder.append(") ");
            stringBuilder.append(str.getMethodName());
            str = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
        }
    }

    public static String getStackTraceMsg() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(k.s);
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(") ");
        stringBuilder.append(stackTraceElement.getMethodName());
        return stringBuilder.toString();
    }
}
