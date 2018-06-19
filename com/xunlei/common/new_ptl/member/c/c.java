package com.xunlei.common.new_ptl.member.c;

import android.text.TextUtils;
import com.alipay.sdk.util.h;

/* compiled from: XLAlipayAuthResult */
public final class c {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public c(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            for (String str2 : str.split(h.b)) {
                if (str2.startsWith("resultStatus=")) {
                    this.a = a(str2, "resultStatus");
                }
                if (str2.startsWith("result=")) {
                    this.b = a(str2, "result");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("result");
                    stringBuilder.append("={");
                    String stringBuilder2 = stringBuilder.toString();
                    int indexOf = str2.indexOf("&sign_type");
                    if (indexOf == -1) {
                        indexOf = str2.lastIndexOf(h.d);
                    }
                    this.i = str2.substring(str2.indexOf(stringBuilder2) + stringBuilder2.length(), indexOf);
                }
                if (str2.startsWith("memo=")) {
                    this.c = a(str2, "memo");
                }
            }
            str = this.b.split("&");
            int length = str.length;
            while (i < length) {
                String str3 = str[i];
                if (str3.startsWith("alipay_open_id=")) {
                    this.f = a(str3);
                }
                if (str3.startsWith("auth_code=")) {
                    this.e = a(str3);
                }
                if (str3.startsWith("result_code=")) {
                    this.d = a(str3);
                }
                if (str3.startsWith("sign_type=")) {
                    this.g = a(str3);
                }
                if (str3.startsWith("sign=")) {
                    this.h = str3.substring(str3.indexOf("=\"") + 2, str3.length() - 1);
                }
                i++;
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("resultStatus={");
        stringBuilder.append(this.a);
        stringBuilder.append("};memo={");
        stringBuilder.append(this.c);
        stringBuilder.append("};result={");
        stringBuilder.append(this.b);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }

    private String g() {
        return this.g;
    }

    public final String a() {
        return this.h;
    }

    public final String b() {
        return this.a;
    }

    private String h() {
        return this.c;
    }

    public final String c() {
        return this.i;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    private static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("={");
        str2 = stringBuilder.toString();
        return str.substring(str.indexOf(str2) + str2.length(), str.lastIndexOf(h.d));
    }

    private static String a(String str) {
        str = str.split("=\"")[1];
        return str.substring(0, str.lastIndexOf("\""));
    }

    private static String b(String str) {
        return str.substring(str.indexOf("=\"") + 2, str.length() - 1);
    }

    private static String b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("={");
        str2 = stringBuilder.toString();
        int indexOf = str.indexOf("&sign_type");
        if (indexOf == -1) {
            indexOf = str.lastIndexOf(h.d);
        }
        return str.substring(str.indexOf(str2) + str2.length(), indexOf);
    }
}
