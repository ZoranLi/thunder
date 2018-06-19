package com.xunlei.downloadprovider.cardslide.d;

import android.location.Location;
import android.os.Build;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.downloadprovider.cardslide.c.a;
import java.util.Calendar;
import java.util.List;

/* compiled from: CardSlideUtil */
public final class c {
    private static String[] a = new String[]{"MI NOTE LTE", "SM-G9287", "X900+"};

    public static String a(int i) {
        String stringBuilder;
        StringBuilder stringBuilder2;
        String stringBuilder3;
        int i2 = i % DateTimeUtil.HOUR_SECOND;
        int i3 = 0;
        if (i > DateTimeUtil.HOUR_SECOND) {
            i /= DateTimeUtil.HOUR_SECOND;
            if (i2 == 0) {
                i2 = 0;
            } else if (i2 > 60) {
                int i4 = i2 / 60;
                i2 %= 60;
                if (i2 != 0) {
                    i3 = i2;
                }
                i2 = i4;
            } else {
                i3 = i2;
                i2 = 0;
            }
        } else {
            i2 = i / 60;
            i %= 60;
            if (i != 0) {
                i3 = i;
                i = 0;
            } else {
                i = 0;
            }
        }
        if (i3 < 10) {
            StringBuilder stringBuilder4 = new StringBuilder("0");
            stringBuilder4.append(i3);
            stringBuilder = stringBuilder4.toString();
        } else {
            stringBuilder = String.valueOf(i3);
        }
        if (i2 < 10) {
            stringBuilder2 = new StringBuilder("0");
            stringBuilder2.append(i2);
            stringBuilder3 = stringBuilder2.toString();
        } else {
            stringBuilder3 = String.valueOf(i2);
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(i);
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder2.append(stringBuilder3);
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.toString();
    }

    public static long a() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return ((instance.getTimeInMillis() / 1000) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) + 7200;
    }

    public static long b() {
        return a.a().c() - (System.currentTimeMillis() / 1000);
    }

    public static void a(String str, List<a> list) {
        String str2 = "";
        if (list.size() > 0) {
            for (int i = 0; i < list.size() - 1; i++) {
                String str3 = ((a) list.get(i)).c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(str3);
                stringBuilder.append("_");
                str2 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(((a) list.get(list.size() - 1)).c);
            str2 = stringBuilder2.toString();
        }
        list = new StringBuilder();
        list.append(str);
        list.append(" resId list = ");
        list.append(str2);
    }

    public static float a(double d, double d2, double d3, double d4) {
        float[] fArr = new float[1];
        Location.distanceBetween(d, d2, d3, d4, fArr);
        return fArr[0] / 1000.0f;
    }

    public static boolean c() {
        String str = Build.MODEL;
        for (String equals : a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
