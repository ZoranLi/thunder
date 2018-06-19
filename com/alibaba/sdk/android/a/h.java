package com.alibaba.sdk.android.a;

import java.security.MessageDigest;

public class h {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(a[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static void a(double d) {
        try {
            Thread.sleep((long) (d * 1000.0d));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return false;
            }
        }
        return true;
    }

    public static String b(String str) {
        return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
    }

    public static String c(String str) {
        return a(MessageDigest.getInstance("SHA-1").digest(str.getBytes()));
    }
}
