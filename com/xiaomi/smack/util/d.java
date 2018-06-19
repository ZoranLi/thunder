package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.string.a;
import java.util.Random;

public class d {
    private static final char[] a = "&quot;".toCharArray();
    private static final char[] b = "&apos;".toCharArray();
    private static final char[] c = "&amp;".toCharArray();
    private static final char[] d = "&lt;".toCharArray();
    private static final char[] e = "&gt;".toCharArray();
    private static Random f = new Random();
    private static char[] g = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(int i) {
        if (i <= 0) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = g[f.nextInt(71)];
        }
        return new String(cArr);
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        int length = toCharArray.length;
        StringBuilder stringBuilder = new StringBuilder((int) (((double) length) * 1.3d));
        int i2 = 0;
        while (i < length) {
            char c = toCharArray[i];
            if (c <= '>') {
                char[] cArr;
                if (c == '<') {
                    if (i > i2) {
                        stringBuilder.append(toCharArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    cArr = d;
                } else if (c == '>') {
                    if (i > i2) {
                        stringBuilder.append(toCharArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    cArr = e;
                } else if (c == '&') {
                    if (i > i2) {
                        stringBuilder.append(toCharArray, i2, i - i2);
                    }
                    int i3 = i + 5;
                    if (length <= i3 || toCharArray[i + 1] != '#' || !Character.isDigit(toCharArray[i + 2]) || !Character.isDigit(toCharArray[i + 3]) || !Character.isDigit(toCharArray[i + 4]) || toCharArray[i3] != ';') {
                        i2 = i + 1;
                        cArr = c;
                    }
                } else if (c == '\"') {
                    if (i > i2) {
                        stringBuilder.append(toCharArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    cArr = a;
                } else if (c == '\'') {
                    if (i > i2) {
                        stringBuilder.append(toCharArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    cArr = b;
                }
                stringBuilder.append(cArr);
            }
            i++;
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            stringBuilder.append(toCharArray, i2, i - i2);
        }
        return stringBuilder.toString();
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf >= 0) {
            char[] toCharArray = str.toCharArray();
            char[] toCharArray2 = str3.toCharArray();
            int length = str2.length();
            StringBuilder stringBuilder = new StringBuilder(toCharArray.length);
            stringBuilder.append(toCharArray, 0, indexOf);
            stringBuilder.append(toCharArray2);
            indexOf += length;
            while (true) {
                int indexOf2 = str.indexOf(str2, indexOf);
                if (indexOf2 <= 0) {
                    break;
                }
                stringBuilder.append(toCharArray, indexOf, indexOf2 - indexOf);
                stringBuilder.append(toCharArray2);
                indexOf = indexOf2 + length;
            }
            stringBuilder.append(toCharArray, indexOf, toCharArray.length - indexOf);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static String a(byte[] bArr) {
        return String.valueOf(a.a(bArr));
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }
}
