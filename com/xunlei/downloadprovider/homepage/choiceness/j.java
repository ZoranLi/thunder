package com.xunlei.downloadprovider.homepage.choiceness;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ChoicenessUtils */
public final class j {
    public static String a(long j) {
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

    public static String a(int i) {
        long j = (long) (i * 1000);
        if (j >= 3600000) {
            i = new SimpleDateFormat("HH:mm:ss");
        } else {
            i = new SimpleDateFormat("mm:ss");
        }
        return i.format(new Date(j));
    }
}
