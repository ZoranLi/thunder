package com.xunlei.tdlive.util;

import java.security.MessageDigest;

/* compiled from: Md5 */
public class f {
    public static String a(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder stringBuilder = new StringBuilder(32);
        for (byte b : bArr) {
            stringBuilder.append(cArr[(b >> 4) & 15]);
            stringBuilder.append(cArr[(b >> 0) & 15]);
        }
        return stringBuilder.toString();
    }

    public static String a(String str) {
        return b(str.getBytes());
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            return a(instance.digest());
        } catch (Throwable th) {
            th.printStackTrace();
            return new String(bArr);
        }
    }
}
