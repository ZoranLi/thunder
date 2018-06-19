package com.xunlei.xllib.b;

import java.math.BigDecimal;

/* compiled from: ConvertUtil */
public abstract class e {
    public static final String[] a = new String[]{"B", "KB", "MB", "GB", "TB"};
    public static final String[] b = new String[]{"B", "K", "M", "G", "T"};
    public static final String[] c = new String[]{"B/s", "KB/s", "MB/s", "GB/s"};

    /* compiled from: ConvertUtil */
    public static class a {
        public static final String[] a = new String[]{"", "K", "M", "G", "T"};

        /* compiled from: ConvertUtil */
        public interface a {
            boolean a(double d, int i, int i2, String[] strArr, String[] strArr2);
        }

        public static String[] a(long j, int i, String[] strArr, a aVar) {
            long j2 = j;
            r2 = new String[2];
            int i2 = 0;
            r2[0] = "";
            r2[1] = "";
            String[] strArr2 = strArr == null ? a : strArr;
            long j3 = j2 < 0 ? -j2 : j2;
            int max = Math.max(strArr2.length - 1, 1);
            while (j3 > 0) {
                j3 /= 1024;
                if (j3 > 0) {
                    i2++;
                    continue;
                }
                if (i2 >= max) {
                    break;
                }
            }
            int i3 = i2;
            int i4 = i;
            aVar.a(new BigDecimal(j2).divide(new BigDecimal(Math.round(Math.pow(1024.0d, (double) i3))), i4, 1).doubleValue(), i3, i4, r2, strArr2);
            return r2;
        }
    }

    public static String a(long j, int i) {
        j = b(j, i, a, true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j[0]);
        stringBuilder.append(j[1]);
        return stringBuilder.toString();
    }

    public static String a(long j, int i, String[] strArr) {
        return a(j, i, strArr, true);
    }

    public static String a(long j, int i, String[] strArr, boolean z) {
        j = b(j, i, strArr, z);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j[0]);
        stringBuilder.append(j[1]);
        return stringBuilder.toString();
    }

    public static String[] b(long j, int i, String[] strArr, boolean z) {
        return a.a(j, i, strArr, new f(z, j));
    }
}
