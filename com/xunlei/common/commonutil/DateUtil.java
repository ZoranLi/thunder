package com.xunlei.common.commonutil;

import android.text.TextUtils;
import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final int ONE_DAY_MILLS = 86400000;
    private static final int ONE_HOUR_MILLS = 3600000;
    private static final int ONE_MIN_MILLS = 60000;
    private static final int ONE_SEC_MILLS = 1000;
    public static final int TEN_DAYS_MILLS = 864000000;
    private static final int TWO_DAY_MILLS = 172800000;

    public static boolean isTheSameDay(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        j = Calendar.getInstance();
        j.setTimeInMillis(j2);
        if (instance.get(1) == j.get(1) && instance.get(2) == j.get(2) && instance.get(5) == j.get(5)) {
            return true;
        }
        return false;
    }

    public static long getMillFromDate_yyyy_MM_dd_HH_mm_ss(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (String str2) {
            str2.printStackTrace();
            str2 = null;
        }
        if (str2 != null) {
            return str2.getTime();
        }
        return 0;
    }

    public static CharSequence formatRelativeTime(long j) {
        return formatRelativeTime(j, System.currentTimeMillis());
    }

    public static CharSequence formatRelativeTime(long j, long j2) {
        long j3 = j2 - j;
        if (j3 <= 1000) {
            return "1秒前";
        }
        if (j3 < 60000) {
            j = new StringBuilder();
            j.append(j3 / 1000);
            j.append("秒前");
            return j.toString();
        } else if (j3 < 3600000) {
            j = new StringBuilder();
            j.append(j3 / 60000);
            j.append("分钟前");
            return j.toString();
        } else if (j3 < 86400000) {
            j = new StringBuilder();
            j.append(j3 / 3600000);
            j.append("小时前");
            return j.toString();
        } else if (j3 < 172800000) {
            return "1天前";
        } else {
            if (isSameYear(j) != null) {
                return DateFormat.format("MM-dd kk:mm", j);
            }
            return DateFormat.format("yy-MM-dd kk:mm", j);
        }
    }

    public static CharSequence formatRelativeTime3(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis < 60000) {
            return "刚刚";
        }
        if (currentTimeMillis < 3600000) {
            j = new StringBuilder();
            j.append(currentTimeMillis / 60000);
            j.append("分钟前");
            return j.toString();
        } else if (currentTimeMillis < 86400000) {
            j = new StringBuilder();
            j.append(currentTimeMillis / 3600000);
            j.append("小时前");
            return j.toString();
        } else if (currentTimeMillis < 864000000) {
            j = new StringBuilder();
            j.append(currentTimeMillis / 86400000);
            j.append("天前");
            return j.toString();
        } else if (isSameYear(j)) {
            return DateFormat.format("MM-dd", j);
        } else {
            return DateFormat.format("yy-MM-dd", j);
        }
    }

    public static CharSequence formatRelativeDay(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(currentTimeMillis);
        int i = instance.get(1);
        int i2 = instance2.get(1);
        int i3 = instance.get(2);
        int i4 = instance2.get(2);
        int i5 = instance.get(5);
        int i6 = instance2.get(5);
        if (i != i2) {
            return DateFormat.format("yy-MM-dd", j);
        }
        if (i3 == i4 && i5 == i6) {
            return "今天";
        }
        if (i3 == i4 && i5 == i6 - 1) {
            return "昨天";
        }
        return DateFormat.format("MM-dd", j);
    }

    public static long date2TimeStamp(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (String str3) {
            str3.printStackTrace();
            return 0;
        }
    }

    private static boolean isSameYear(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        j = Calendar.getInstance();
        j.setTimeInMillis(System.currentTimeMillis());
        if (instance.get(1) == j.get(1)) {
            return true;
        }
        return 0;
    }

    public static String formatDuration(int i) {
        long j = (long) (i * 1000);
        if (j >= 3600000) {
            i = new SimpleDateFormat("HH:mm:ss");
        } else {
            i = new SimpleDateFormat("mm:ss");
        }
        return i.format(new Date(j));
    }

    public static String format(long j, String str) {
        return (j <= 0 || TextUtils.isEmpty(str)) ? "--" : new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }
}
