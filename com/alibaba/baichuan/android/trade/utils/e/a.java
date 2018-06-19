package com.alibaba.baichuan.android.trade.utils.e;

import java.security.MessageDigest;

public final class a {
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
