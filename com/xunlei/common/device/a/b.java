package com.xunlei.common.device.a;

import com.xunlei.common.stat.base.a.a;
import java.security.MessageDigest;

/* compiled from: SHA1 */
public final class b {
    public static String a(String str) {
        str = a.a(str.getBytes());
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        for (byte b : str) {
            stringBuilder.append(cArr[(b >> 4) & 15]);
            stringBuilder.append(cArr[b & 15]);
        }
        return stringBuilder.toString();
    }

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }
}
