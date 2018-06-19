package com.alibaba.mtl.log.e;

import java.security.MessageDigest;

/* compiled from: MD5Utils */
public final class j {
    public static char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(a[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static String b(byte[] bArr) {
        bArr = c(bArr);
        return bArr != null ? a(bArr) : "0000000000000000";
    }

    public static byte[] c(byte[] bArr) {
        if (bArr != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                return instance.digest();
            } catch (byte[] bArr2) {
                bArr2.printStackTrace();
            }
        }
        return null;
    }
}
