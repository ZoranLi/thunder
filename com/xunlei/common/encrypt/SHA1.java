package com.xunlei.common.encrypt;

import java.security.MessageDigest;

public class SHA1 {
    public static String encrypt(String str) {
        str = encrypt(str.getBytes());
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

    public static byte[] encrypt(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }
}
