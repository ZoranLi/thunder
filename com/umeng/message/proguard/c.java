package com.umeng.message.proguard;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AesHelper */
public class c {
    private static byte[] a = "uLi4/f4+Pb39.T19".getBytes();
    private static byte[] b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("nmeug");
        stringBuilder.append(".f9/");
        stringBuilder.append("Om+L823");
        b = stringBuilder.toString().getBytes();
    }

    public static String a(String... strArr) throws Exception {
        String str;
        String str2 = null;
        if (strArr.length == 2) {
            str = strArr[0];
            strArr = strArr[1];
        } else if (strArr.length == 3) {
            str2 = strArr[0];
            str = strArr[1];
            String str3 = str2;
            str2 = strArr[2];
            strArr = str;
            str = str3;
        } else {
            strArr = null;
            str = strArr;
        }
        if (str2 != null && str2.length() == 16) {
            a = str2.getBytes();
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
        return d.d(instance.doFinal(str.getBytes(strArr)));
    }

    public static String a(String str, String str2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
        return new String(instance.doFinal(d.b(str)), str2);
    }

    public static String b(String str, String str2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec("uLi4/f4+Pb39.T19".getBytes(), "AES"), new IvParameterSpec(b));
        return new String(instance.doFinal(d.b(str)), str2);
    }

    public static String a(String str) throws Exception {
        String str2 = "uLi4/f4+Pb39.T19";
        if (str2.length() == 16) {
            a = str2.getBytes();
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, new SecretKeySpec(a, "AES"), new IvParameterSpec(b));
        return d.d(instance.doFinal(str.getBytes("UTF-8")));
    }
}
