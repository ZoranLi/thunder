package com.xunlei.common.androidutil;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
    public static final int DAY_SECOND = 86400;
    public static final int HOUR_SECOND = 3600;
    public static final int MIN_SECOND = 60;
    public static final int MONTH_SECOND = 2592000;
    public static final int MULTIPLER = 60;
    private static final String TAG = "DateTimeUtil";
    public static final int YEAR_SECOND = 31104000;

    public static String getDate() {
        return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
    }

    public static String getDateTime(long j) {
        return j > 0 ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j)) : 0;
    }

    public static java.lang.String getTimeDiscribe(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.text.SimpleDateFormat;
        r1 = "yyyy-MM-dd HH:mm:ss";
        r0.<init>(r1);
        r6 = r0.parse(r6);	 Catch:{ Exception -> 0x0023 }
        r0 = java.lang.System.currentTimeMillis();
        r2 = r6.getTime();
        r4 = r0 - r2;
        r0 = 0;
        r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r6 > 0) goto L_0x001e;
    L_0x001b:
        r6 = "";
        return r6;
    L_0x001e:
        r6 = getTimeDiscribe(r4);
        return r6;
    L_0x0023:
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.DateTimeUtil.getTimeDiscribe(java.lang.String):java.lang.String");
    }

    public static String getTimeDiscribe(long j) {
        j /= 1000;
        long j2 = j / 60;
        long j3 = j2 / 60;
        long j4 = j3 / 24;
        StringBuilder stringBuilder = new StringBuilder("day = ");
        stringBuilder.append(j4);
        stringBuilder.append("; hour = ");
        stringBuilder.append(j3);
        stringBuilder.append("; minute = ");
        stringBuilder.append(j2);
        stringBuilder.append("; second = ");
        stringBuilder.append(j);
        if (j4 >= 30) {
            return "一个月";
        }
        if (j4 > 0) {
            j = new StringBuilder();
            j.append(j4);
            j.append("天");
            return j.toString();
        } else if (j3 > 0) {
            j = new StringBuilder();
            j.append(j3);
            j.append("小时");
            return j.toString();
        } else if (j2 <= 0) {
            return "1分钟";
        } else {
            j = new StringBuilder();
            j.append(j2);
            j.append("分钟");
            return j.toString();
        }
    }

    public static String getTimeString(int i, Context context) {
        StringBuilder stringBuilder;
        context = new StringBuilder();
        int i2 = i / YEAR_SECOND;
        i -= YEAR_SECOND * i2;
        int i3 = i / MONTH_SECOND;
        i -= MONTH_SECOND * i3;
        int i4 = i / 86400;
        i -= 86400 * i4;
        int i5 = i / HOUR_SECOND;
        i -= i5 * HOUR_SECOND;
        int i6 = i / 60;
        i -= i6 * 60;
        if (i2 > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(String.valueOf(i2));
            stringBuilder2.append("年");
            context.append(stringBuilder2.toString());
        }
        if (i3 > 0) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(String.valueOf(i3));
            stringBuilder3.append("月");
            context.append(stringBuilder3.toString());
        }
        if (i4 > 0) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(String.valueOf(i4));
            stringBuilder3.append("日");
            context.append(stringBuilder3.toString());
        }
        if (i5 > 0) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(String.valueOf(i5));
            stringBuilder3.append("小时");
            context.append(stringBuilder3.toString());
        }
        if (i6 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i6));
            stringBuilder.append("分");
            context.append(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(i));
        stringBuilder.append("秒");
        context.append(stringBuilder.toString());
        return context.toString();
    }

    public static String formatTimeWithDefault(long j) {
        return j > 0 ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j)) : "--";
    }

    public static long getHour(long j) {
        return j / 3600;
    }

    public static long getMinite(long j) {
        return (j - ((j / 3600) * 3600)) / 60;
    }

    public static long getModeSeconds(long j) {
        return j % 60;
    }

    public static String getFormatString(long j) {
        String str = "";
        if (j <= 0) {
            return str;
        }
        long hour = getHour(j);
        long minite = getMinite(j);
        j = getModeSeconds(j);
        if (hour > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(hour);
            stringBuilder.append("小时");
            str = stringBuilder.toString();
        }
        if (minite > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(minite);
            stringBuilder2.append("分钟");
            str = stringBuilder2.toString();
        }
        if (j > 0 && TextUtils.isEmpty(r0)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("秒");
            str = stringBuilder.toString();
        }
        return str;
    }
}
