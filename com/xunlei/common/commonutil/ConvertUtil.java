package com.xunlei.common.commonutil;

import com.xunlei.xllib.b.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ConvertUtil {
    private static final long BASE_B = 1;
    private static final long BASE_GB = 1073741824;
    private static final long BASE_KB = 1024;
    private static final long BASE_MB = 1048576;
    private static final long BASE_TB = 1099511627776L;
    private static final String[] DISPLAY_NAME = new String[]{UNIT_BYTE, UNIT_KB, UNIT_MB, UNIT_GB, UNIT_TB};
    private static final String UNIT_BYTE = "B";
    private static final String UNIT_GB = "GB";
    private static final String UNIT_KB = "KB";
    private static final String UNIT_MB = "MB";
    private static final String UNIT_TB = "TB";

    public static String byteConvert(long j) {
        return e.a(j, 1, DISPLAY_NAME);
    }

    public static String byteConvert(long j, int i) {
        return e.a(j, i, DISPLAY_NAME);
    }

    public static String byteConvert(long j, boolean z) {
        j = byteConvert(j);
        if (!z || j.length() < true) {
            return j;
        }
        String substring = j.substring(0, 4);
        if (substring.endsWith(".")) {
            substring = substring.substring(0, 3);
        }
        z = new StringBuilder();
        z.append(substring);
        z.append(j.substring(j.length() - 2, j.length()));
        return z.toString();
    }

    @Deprecated
    public static String convertFileSize(long j, int i) {
        long j2;
        double d = (double) j;
        int i2 = 0;
        do {
            j2 = 1024;
            j /= 1024;
            if (j <= 0) {
                break;
            }
            i2++;
        } while (i2 != 4);
        switch (i2) {
            case 0:
                j2 = 1;
                j = UNIT_BYTE;
                break;
            case 1:
                j = UNIT_KB;
                break;
            case 2:
                j2 = 1048576;
                j = UNIT_MB;
                break;
            case 3:
                j2 = BASE_GB;
                j = UNIT_GB;
                break;
            default:
                j2 = BASE_TB;
                j = UNIT_TB;
                break;
        }
        String d2 = Double.toString(new BigDecimal(d).divide(new BigDecimal(j2), i, 4).doubleValue());
        if (i == 0) {
            i = d2.indexOf(46);
            if (-1 == i) {
                i = new StringBuilder();
                i.append(d2);
                i.append(j);
                return i.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d2.substring(0, i));
            stringBuilder.append(j);
            return stringBuilder.toString();
        }
        if (j.equals(UNIT_BYTE) != 0) {
            d2 = d2.substring(0, d2.indexOf(46));
        }
        if (j.equals(UNIT_KB) != 0) {
            i = d2.indexOf(46);
            if (i != -1) {
                d2 = d2.substring(0, i + 2);
            } else {
                i = new StringBuilder();
                i.append(d2);
                i.append(".0");
                d2 = i.toString();
            }
        }
        i = new StringBuilder();
        i.append(d2);
        i.append(j);
        return i.toString();
    }

    public static String decimal2String(long j, int i, int i2, String str) {
        if (j < ((long) i)) {
            return j >= 0 ? String.valueOf(j) : "";
        } else {
            i = new DecimalFormat();
            i.setMaximumFractionDigits(1);
            i.setGroupingSize(0);
            i.setRoundingMode(RoundingMode.HALF_UP);
            j = i.format((double) ((((float) j) * 1.0f) / ((float) i2)));
            int indexOf = j.indexOf(".");
            if (indexOf > 0) {
                i = indexOf + 1;
                if (j.substring(indexOf, i).contentEquals("0")) {
                    j = j.substring(0, i);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }
}
