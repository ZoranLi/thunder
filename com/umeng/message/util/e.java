package com.umeng.message.util;

import com.xiaomi.mipush.sdk.Constants;
import java.util.List;

/* compiled from: StringUtils */
public class e {
    public static String a(String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(append);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (stringBuilder.length() > null && stringBuilder.charAt(stringBuilder.length() - 1) == 44) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static String a(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(append);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (stringBuilder.length() > null && stringBuilder.charAt(stringBuilder.length() - 1) == 44) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
