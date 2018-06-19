package com.alibaba.sdk.android.feedback.xblink.i;

public class c {
    private static String a = "0123456789ABCDEF";

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr != null) {
            if (bArr.length > 0) {
                for (byte b : bArr) {
                    String toHexString = Integer.toHexString(b & 255);
                    if (toHexString.length() < 2) {
                        stringBuilder.append(0);
                    }
                    stringBuilder.append(toHexString);
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
