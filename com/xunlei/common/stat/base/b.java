package com.xunlei.common.stat.base;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: XLDeviceInfo */
public final class b {
    public static String a() {
        return VERSION.RELEASE;
    }

    public static String b() {
        return Build.MODEL;
    }

    public static String c() {
        String toLowerCase = Build.MANUFACTURER.toLowerCase();
        String toLowerCase2 = Build.MODEL.toLowerCase();
        if (toLowerCase2.startsWith(toLowerCase)) {
            return a(toLowerCase2);
        }
        Object a = a(toLowerCase);
        if (TextUtils.isEmpty(a)) {
            return a(toLowerCase2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(" ");
        stringBuilder.append(a(toLowerCase2));
        return stringBuilder.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        Object obj = 1;
        for (char c : str.toCharArray()) {
            if (obj == null || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    obj = 1;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(c);
                str2 = stringBuilder.toString();
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(Character.toUpperCase(c));
                str2 = stringBuilder2.toString();
                obj = null;
            }
        }
        return str2;
    }
}
