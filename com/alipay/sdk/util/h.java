package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.app.statistic.c;

public final class h {
    public static final String a = "pref_trade_token";
    public static final String b = ";";
    public static final String c = "result={";
    public static final String d = "}";
    public static final String e = "trade_token=\"";
    public static final String f = "\"";
    public static final String g = "trade_token=";

    private static void a(Context context, String str) {
        try {
            Object obj = null;
            if (!TextUtils.isEmpty(str)) {
                str = str.split(b);
                String str2 = null;
                int i = 0;
                while (i < str.length) {
                    if (str[i].startsWith(c) && str[i].endsWith(d)) {
                        String[] split = str[i].substring(8, str[i].length() - 1).split("&");
                        int i2 = 0;
                        while (i2 < split.length) {
                            if (split[i2].startsWith(e) && split[i2].endsWith("\"")) {
                                str2 = split[i2].substring(13, split[i2].length() - 1);
                                break;
                            } else if (split[i2].startsWith(g)) {
                                str2 = split[i2].substring(12);
                                break;
                            } else {
                                i2++;
                            }
                        }
                    }
                    i++;
                }
                obj = str2;
            }
            if (TextUtils.isEmpty(obj) == null) {
                i.a(context, a, obj);
            }
        } catch (Throwable th) {
            a.a("biz", c.x, th);
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = str.split(b);
        String str2 = null;
        int i = 0;
        while (i < str.length) {
            if (str[i].startsWith(c) && str[i].endsWith(d)) {
                String[] split = str[i].substring(8, str[i].length() - 1).split("&");
                int i2 = 0;
                while (i2 < split.length) {
                    if (split[i2].startsWith(e) && split[i2].endsWith("\"")) {
                        str2 = split[i2].substring(13, split[i2].length() - 1);
                        break;
                    } else if (split[i2].startsWith(g)) {
                        str2 = split[i2].substring(12);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            i++;
        }
        return str2;
    }

    private static String a(Context context) {
        return i.b(context, a, "");
    }
}
