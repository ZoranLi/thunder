package com.qihoo360.a.a;

import java.util.List;

/* compiled from: StringUtils */
public final class d {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static final String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(a[(b & 240) >> 4]);
            stringBuilder.append(a[b & 15]);
        }
        return stringBuilder.toString();
    }

    public static String a(List<?> list) {
        return list.toString().replace(", ", ", \n");
    }
}
