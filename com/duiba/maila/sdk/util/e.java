package com.duiba.maila.sdk.util;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Hashtable;

public final class e {
    private static Hashtable<String, e> a = new Hashtable();
    private static e c;
    private String b;

    public static e a() {
        if (c == null) {
            c = new e("@XIAN@");
        }
        return c;
    }

    private e(String str) {
        this.b = str;
    }

    public final String b() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || stackTraceElement.getClassName().equals(getClass().getName())) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b);
                stringBuilder.append("[ ");
                stringBuilder.append(Thread.currentThread().getName());
                stringBuilder.append(": ");
                stringBuilder.append(stackTraceElement.getFileName());
                stringBuilder.append(Constants.COLON_SEPARATOR);
                stringBuilder.append(stackTraceElement.getLineNumber());
                stringBuilder.append(" ");
                stringBuilder.append(stackTraceElement.getMethodName());
                stringBuilder.append(" ]");
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
