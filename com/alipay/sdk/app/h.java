package com.alipay.sdk.app;

public final class h {
    public static String a;

    private static void a(String str) {
        a = str;
    }

    private static String b() {
        return a;
    }

    public static String a() {
        i a = i.a(i.CANCELED.h);
        return a(a.h, a.i, "");
    }

    private static String c() {
        i a = i.a(i.DOUBLE_REQUEST.h);
        return a(a.h, a.i, "");
    }

    private static String d() {
        i a = i.a(i.PARAMS_ERROR.h);
        return a(a.h, a.i, "");
    }

    public static String a(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("resultStatus={");
        stringBuilder.append(i);
        stringBuilder.append("};memo={");
        stringBuilder.append(str);
        stringBuilder.append("};result={");
        stringBuilder.append(str2);
        stringBuilder.append(com.alipay.sdk.util.h.d);
        return stringBuilder.toString();
    }
}
