package com.tencent.smtt.utils;

public class c {
    public static String a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length > 0) {
                StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
                for (int i = 0; i < bArr.length; i++) {
                    if ((bArr[i] & 255) < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Long.toString((long) (bArr[i] & 255), 16));
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }
}
