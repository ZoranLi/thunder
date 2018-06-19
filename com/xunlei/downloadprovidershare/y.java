package com.xunlei.downloadprovidershare;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: ShareUtils */
public final class y {
    public static String a(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("appendUrlParams url can not empty");
        }
        if (hashMap != null) {
            if (!hashMap.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(str);
                if (!str.contains("?")) {
                    stringBuilder.append('?');
                } else if (str.charAt(str.length() - 1) != 38) {
                    stringBuilder.append('&');
                }
                for (String str2 : hashMap.keySet()) {
                    String str3 = (String) hashMap.get(str2);
                    stringBuilder.append(str2);
                    stringBuilder.append('=');
                    stringBuilder.append(str3);
                    stringBuilder.append('&');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                return stringBuilder.toString();
            }
        }
        return str;
    }
}
