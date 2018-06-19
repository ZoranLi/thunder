package com.xunlei.common.new_ptl.pay.a;

import com.alipay.sdk.util.h;

/* compiled from: XLPayResult */
public final class g {
    public String a = "";
    public String b = "";
    private String c = "";

    public g(String str) {
        try {
            for (String str2 : str.split(h.b)) {
                if (str2.startsWith("resultStatus")) {
                    this.a = a(str2, "resultStatus");
                }
                if (str2.startsWith("result")) {
                    this.b = a(str2, "result");
                }
                if (str2.startsWith("memo")) {
                    this.c = a(str2, "memo");
                }
            }
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("resultStatus : ");
        stringBuilder.append(this.a);
        stringBuilder.append(", result = ");
        stringBuilder.append(this.b);
        stringBuilder.append(", memo = ");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }

    private static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("={");
        str2 = stringBuilder.toString();
        return str.substring(str.indexOf(str2) + str2.length(), str.indexOf(h.d));
    }
}
