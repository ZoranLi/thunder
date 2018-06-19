package com.xiaomi.channel.commonutils.misc;

public class e {
    static final char[] a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            stringBuilder.append(a[i4 >> 4]);
            stringBuilder.append(a[i4 & 15]);
        }
        return stringBuilder.toString();
    }
}
