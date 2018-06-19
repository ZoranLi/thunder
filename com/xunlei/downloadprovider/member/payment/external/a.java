package com.xunlei.downloadprovider.member.payment.external;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtil */
public final class a {
    public static String a(String str, String str2) throws Exception {
        str = a(str).getEncoded();
        str2 = str2.getBytes("UTF-8");
        Key secretKeySpec = new SecretKeySpec(str, "AES");
        str = Cipher.getInstance("AES/CBC/PKCS5Padding");
        str.init(1, secretKeySpec, new IvParameterSpec(new byte[str.getBlockSize()]));
        return a(str.doFinal(str2));
    }

    public static String b(String str, String str2) throws Exception {
        str = a(str).getEncoded();
        int length = str2.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = 2 * i;
            bArr[i] = Integer.valueOf(str2.substring(i2, i2 + 2), 16).byteValue();
        }
        str2 = new SecretKeySpec(str, "AES");
        str = Cipher.getInstance("AES/CBC/PKCS5Padding");
        str.init(2, str2, new IvParameterSpec(new byte[str.getBlockSize()]));
        return new String(str.doFinal(bArr));
    }

    private static SecretKey a(String str) throws Exception {
        return new SecretKeySpec(b.a(str.getBytes("UTF-8")), "AES");
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(2 * bArr.length);
        for (byte b : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
        }
        return stringBuffer.toString();
    }
}
