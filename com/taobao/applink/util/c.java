package com.taobao.applink.util;

import java.security.MessageDigest;

public class c {
    public static String a(String str) {
        if (e.a(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            byte[] digest = instance.digest();
            for (int i : digest) {
                int i2;
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            th.toString();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        try {
            bArr = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                int i = b & 255;
                if (i < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i));
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
