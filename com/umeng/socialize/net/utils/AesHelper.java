package com.umeng.socialize.net.utils;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesHelper {
    private static final String UTF_8 = "UTF-8";
    private static byte[] iv = "nmeug.f9/Om+L823".getBytes();
    private static byte[] pwd;

    public static String encryptNoPadding(String str, String str2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        int blockSize = instance.getBlockSize();
        str = str.getBytes(str2);
        str2 = str.length;
        int i = str2 % blockSize;
        if (i != 0) {
            str2 += blockSize - i;
        }
        str2 = new byte[str2];
        System.arraycopy(str, 0, str2, 0, str.length);
        instance.init(1, new SecretKeySpec(pwd, "AES"), new IvParameterSpec(iv));
        return Base64.encodeBase64String(instance.doFinal(str2));
    }

    public static String decryptNoPadding(String str, String str2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        instance.init(2, new SecretKeySpec(pwd, "AES"), new IvParameterSpec(iv));
        return new String(instance.doFinal(Base64.decodeBase64(str)), str2);
    }

    public static void setPassword(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = md5(str);
            if (str.length() >= 16) {
                str = str.substring(0, 16);
            }
            pwd = str.getBytes();
        }
    }

    public static byte[] getBytesUtf8(String str) {
        return getBytesUnchecked(str, "UTF-8");
    }

    public static byte[] getBytesUnchecked(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (String str3) {
            throw newIllegalStateException(str2, str3);
        }
    }

    private static IllegalStateException newIllegalStateException(String str, UnsupportedEncodingException unsupportedEncodingException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(": ");
        stringBuilder.append(unsupportedEncodingException);
        return new IllegalStateException(stringBuilder.toString());
    }

    public static String newString(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (byte[] bArr2) {
            throw newIllegalStateException(str, bArr2);
        }
    }

    public static String newStringUtf8(byte[] bArr) {
        return newString(bArr, "UTF-8");
    }

    public static java.lang.String md5(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r7 != 0) goto L_0x0004;
    L_0x0002:
        r7 = 0;
        return r7;
    L_0x0004:
        r0 = r7.getBytes();	 Catch:{ Exception -> 0x003e }
        r1 = "MD5";	 Catch:{ Exception -> 0x003e }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003e }
        r1.reset();	 Catch:{ Exception -> 0x003e }
        r1.update(r0);	 Catch:{ Exception -> 0x003e }
        r0 = r1.digest();	 Catch:{ Exception -> 0x003e }
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x003e }
        r1.<init>();	 Catch:{ Exception -> 0x003e }
        r2 = 0;	 Catch:{ Exception -> 0x003e }
        r3 = r2;	 Catch:{ Exception -> 0x003e }
    L_0x001f:
        r4 = r0.length;	 Catch:{ Exception -> 0x003e }
        if (r3 >= r4) goto L_0x0039;	 Catch:{ Exception -> 0x003e }
    L_0x0022:
        r4 = "%02X";	 Catch:{ Exception -> 0x003e }
        r5 = 1;	 Catch:{ Exception -> 0x003e }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x003e }
        r6 = r0[r3];	 Catch:{ Exception -> 0x003e }
        r6 = java.lang.Byte.valueOf(r6);	 Catch:{ Exception -> 0x003e }
        r5[r2] = r6;	 Catch:{ Exception -> 0x003e }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x003e }
        r1.append(r4);	 Catch:{ Exception -> 0x003e }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x003e }
        goto L_0x001f;	 Catch:{ Exception -> 0x003e }
    L_0x0039:
        r0 = r1.toString();	 Catch:{ Exception -> 0x003e }
        return r0;
    L_0x003e:
        r0 = "[^[a-z][A-Z][0-9][.][_]]";
        r1 = "";
        r7 = r7.replaceAll(r0, r1);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.AesHelper.md5(java.lang.String):java.lang.String");
    }
}
