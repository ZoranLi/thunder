package com.alipay.sdk.packet;

import android.text.TextUtils;
import com.alipay.sdk.app.statistic.c;
import com.alipay.sdk.util.h;

public final class a {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = str.split("&");
        if (str.length == 0) {
            return "";
        }
        Object obj = null;
        Object obj2 = obj;
        Object obj3 = obj2;
        Object obj4 = obj3;
        for (String str2 : str) {
            if (TextUtils.isEmpty(obj)) {
                obj = !str2.contains("biz_type") ? null : e(str2);
            }
            if (TextUtils.isEmpty(obj2)) {
                obj2 = !str2.contains("biz_no") ? null : e(str2);
            }
            if (TextUtils.isEmpty(obj3)) {
                if (str2.contains(c.F)) {
                    if (!str2.startsWith(c.E)) {
                        obj3 = e(str2);
                    }
                }
                obj3 = null;
            }
            if (TextUtils.isEmpty(obj4)) {
                obj4 = !str2.contains("app_userid") ? null : e(str2);
            }
        }
        str = new StringBuilder();
        if (!TextUtils.isEmpty(obj)) {
            StringBuilder stringBuilder = new StringBuilder("biz_type=");
            stringBuilder.append(obj);
            stringBuilder.append(h.b);
            str.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(obj2)) {
            stringBuilder = new StringBuilder("biz_no=");
            stringBuilder.append(obj2);
            stringBuilder.append(h.b);
            str.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(obj3)) {
            stringBuilder = new StringBuilder("trade_no=");
            stringBuilder.append(obj3);
            stringBuilder.append(h.b);
            str.append(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder = new StringBuilder("app_userid=");
            stringBuilder.append(obj4);
            stringBuilder.append(h.b);
            str.append(stringBuilder.toString());
        }
        str = str.toString();
        if (str.endsWith(h.b)) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private static String b(String str) {
        if (str.contains("biz_type")) {
            return e(str);
        }
        return null;
    }

    private static String c(String str) {
        if (str.contains("biz_no")) {
            return e(str);
        }
        return null;
    }

    private static String d(String str) {
        if (str.contains(c.F)) {
            if (!str.startsWith(c.E)) {
                return e(str);
            }
        }
        return null;
    }

    private static String e(String str) {
        str = str.split("=");
        if (str.length <= 1) {
            return null;
        }
        str = str[1];
        return str.contains("\"") ? str.replaceAll("\"", "") : str;
    }

    private static String f(String str) {
        if (str.contains("app_userid")) {
            return e(str);
        }
        return null;
    }
}
