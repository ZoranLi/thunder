package com.alibaba.sdk.android.httpdns;

import com.xiaomi.mipush.sdk.Constants;

class e {
    private static int a = -1;
    private static boolean f4a = false;

    private static String a() {
        if (a == -1) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i = 0;
            int length = stackTrace.length;
            int i2 = 0;
            while (i < length) {
                if (stackTrace[i].getMethodName().equals("getTraceInfo")) {
                    a = i2 + 1;
                    break;
                }
                i2++;
                i++;
            }
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[a + 1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(" - [");
        stringBuilder.append(stackTraceElement.getMethodName());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static void a(Throwable th) {
        if (f4a && th != null) {
            th.printStackTrace();
        }
    }

    static void d(String str) {
        if (f4a && str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Thread.currentThread().getId());
            stringBuilder.append(" - ");
            stringBuilder.append(a());
            stringBuilder.append(" - ");
            stringBuilder.append(str);
        }
    }

    static void e(String str) {
        if (f4a && str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Thread.currentThread().getId());
            stringBuilder.append(" - ");
            stringBuilder.append(a());
            stringBuilder.append(" - ");
            stringBuilder.append(str);
        }
    }

    static synchronized void setLogEnabled(boolean z) {
        synchronized (e.class) {
            f4a = z;
        }
    }
}
