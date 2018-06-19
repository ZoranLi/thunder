package com.xunlei.common.commonutil;

import java.text.DecimalFormat;

public class DataUtil {
    public static String formatCount(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        j = new DecimalFormat("#.0").format((double) (((float) j) / 10000.0f));
        if (j.charAt(j.length() - 1) == '0') {
            j = j.substring(0, j.length() - 2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("万");
        return stringBuilder.toString();
    }
}
