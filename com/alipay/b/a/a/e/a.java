package com.alipay.b.a.a.e;

import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class a {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String toString() {
        String substring;
        String substring2;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        StringBuilder stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(this.a);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(this.b);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(this.c);
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(this.d);
        stringBuffer.append(stringBuilder.toString());
        if (!com.alipay.b.a.a.a.a.a(this.e)) {
            if (this.e.length() >= 20) {
                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                substring = this.e.substring(0, 20);
                stringBuilder.append(substring);
                stringBuffer.append(stringBuilder.toString());
                if (!com.alipay.b.a.a.a.a.a(this.f)) {
                    if (this.f.length() < 20) {
                        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        substring = this.f.substring(0, 20);
                        stringBuilder.append(substring);
                        stringBuffer.append(stringBuilder.toString());
                        if (!com.alipay.b.a.a.a.a.a(this.g)) {
                            if (this.g.length() >= 20) {
                                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                substring2 = this.g.substring(0, 20);
                                stringBuilder.append(substring2);
                                stringBuffer.append(stringBuilder.toString());
                                return stringBuffer.toString();
                            }
                        }
                        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        substring2 = this.g;
                        stringBuilder.append(substring2);
                        stringBuffer.append(stringBuilder.toString());
                        return stringBuffer.toString();
                    }
                }
                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                substring = this.f;
                stringBuilder.append(substring);
                stringBuffer.append(stringBuilder.toString());
                if (com.alipay.b.a.a.a.a.a(this.g)) {
                    if (this.g.length() >= 20) {
                        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        substring2 = this.g.substring(0, 20);
                        stringBuilder.append(substring2);
                        stringBuffer.append(stringBuilder.toString());
                        return stringBuffer.toString();
                    }
                }
                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                substring2 = this.g;
                stringBuilder.append(substring2);
                stringBuffer.append(stringBuilder.toString());
                return stringBuffer.toString();
            }
        }
        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        substring = this.e;
        stringBuilder.append(substring);
        stringBuffer.append(stringBuilder.toString());
        if (com.alipay.b.a.a.a.a.a(this.f)) {
            if (this.f.length() < 20) {
                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                substring = this.f.substring(0, 20);
                stringBuilder.append(substring);
                stringBuffer.append(stringBuilder.toString());
                if (com.alipay.b.a.a.a.a.a(this.g)) {
                    if (this.g.length() >= 20) {
                        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        substring2 = this.g.substring(0, 20);
                        stringBuilder.append(substring2);
                        stringBuffer.append(stringBuilder.toString());
                        return stringBuffer.toString();
                    }
                }
                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                substring2 = this.g;
                stringBuilder.append(substring2);
                stringBuffer.append(stringBuilder.toString());
                return stringBuffer.toString();
            }
        }
        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        substring = this.f;
        stringBuilder.append(substring);
        stringBuffer.append(stringBuilder.toString());
        if (com.alipay.b.a.a.a.a.a(this.g)) {
            if (this.g.length() >= 20) {
                stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                substring2 = this.g.substring(0, 20);
                stringBuilder.append(substring2);
                stringBuffer.append(stringBuilder.toString());
                return stringBuffer.toString();
            }
        }
        stringBuilder = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
        substring2 = this.g;
        stringBuilder.append(substring2);
        stringBuffer.append(stringBuilder.toString());
        return stringBuffer.toString();
    }
}
