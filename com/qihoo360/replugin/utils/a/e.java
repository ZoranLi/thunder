package com.qihoo360.replugin.utils.a;

/* compiled from: ByteConvertor */
public final class e {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str = "0123456789abcdef";
        StringBuilder stringBuilder = new StringBuilder(2 * bArr.length);
        for (byte b : bArr) {
            stringBuilder.append(str.charAt((b >> 4) & 15));
            stringBuilder.append(str.charAt(b & 15));
        }
        return stringBuilder.toString();
    }
}
