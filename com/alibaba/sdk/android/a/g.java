package com.alibaba.sdk.android.a;

import com.xiaomi.mipush.sdk.Constants;

public class g {
    private String a;
    private boolean b = false;

    public g(String str) {
        if (!h.a(str)) {
            this.a = str;
        }
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = 0;
        int length = stackTrace.length;
        int i2 = 0;
        while (i < length && !stackTrace[i].getMethodName().equals("getTraceInfo")) {
            i2++;
            i++;
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i2 + 2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(" - [");
        stringBuilder.append(stackTraceElement.getMethodName());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void a(String str) {
    }

    public void a(Throwable th) {
        if (this.b && th != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append(" - ");
            stringBuilder.append(th.toString());
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(String str) {
    }

    public void c(String str) {
        if (this.b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append(" - ");
            stringBuilder.append(str);
        }
    }
}
