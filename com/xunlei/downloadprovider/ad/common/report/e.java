package com.xunlei.downloadprovider.ad.common.report;

/* compiled from: ErrorInfo */
public final class e {
    public int a;
    public String b;

    private e(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("errorCode=");
        stringBuilder.append(this.a);
        stringBuilder.append(", errorMsg='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        return stringBuilder.toString();
    }

    public static e a(int i, String str) {
        return new e(i, str);
    }
}
