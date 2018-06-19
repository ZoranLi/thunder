package com.umeng.message.common;

public class UmLog {
    public static boolean LOG = true;

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void i(String str, String str2) {
    }

    public static void v(String str, String str2) {
    }

    public static void w(String str, String str2) {
    }

    public static void i(String str, String str2, Exception exception) {
        if (LOG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
        }
    }

    public static void e(String str, String str2, Exception exception) {
        if (LOG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                new StringBuilder("        at\t ").append(stackTraceElement.toString());
            }
        }
    }

    public static void d(String str, String str2, Exception exception) {
        if (LOG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
        }
    }

    public static void v(String str, String str2, Exception exception) {
        if (LOG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
        }
    }

    public static void w(String str, String str2, Exception exception) {
        if (LOG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                new StringBuilder("        at\t ").append(stackTraceElement.toString());
            }
        }
    }
}
