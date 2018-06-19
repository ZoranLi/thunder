package com.xunlei.analytics.c;

import com.tencent.connect.common.Constants;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import com.xunlei.downloadprovider.pushmessage.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Vector;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class a {
    private static final String a = "AES";
    private static final String[] b = new String[]{"0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", "a", b.a, c.a, d.a, e.a, f.a};

    private static String a(byte b) {
        int i;
        if (b < (byte) 0) {
            i = b + 256;
        }
        int i2 = (i >>> 4) & 15;
        i &= 15;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b[i2]);
        stringBuilder.append(b[i]);
        return stringBuilder.toString();
    }

    public static String a(Map<String, String> map, String str) {
        Vector vector = new Vector();
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("=");
            stringBuilder.append(str3);
            vector.add(stringBuilder.toString());
        }
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        int i = 0;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            for (int length = strArr.length - 1; length > i2; length--) {
                int i3 = length - 1;
                if (strArr[length].compareTo(strArr[i3]) < 0) {
                    str3 = strArr[length];
                    strArr[length] = strArr[i3];
                    strArr[i3] = str3;
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        while (i < strArr.length) {
            stringBuilder2.append(strArr[i]);
            i++;
        }
        stringBuilder2.append(str);
        return b(stringBuilder2.toString());
    }

    public static java.lang.String a(byte[] r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ Exception -> 0x000f }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x000f }
        r1 = r0.digest(r1);	 Catch:{ Exception -> 0x000f }
        r1 = c(r1);	 Catch:{ Exception -> 0x000f }
        return r1;
    L_0x000f:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.analytics.c.a.a(byte[]):java.lang.String");
    }

    public static byte[] a(String str) {
        Exception exception;
        byte[] bArr = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return toByteArray;
            } catch (Exception e) {
                Exception exception2 = e;
                bArr = toByteArray;
                exception = exception2;
                exception.printStackTrace();
                return bArr;
            }
        } catch (Exception e2) {
            exception = e2;
            exception.printStackTrace();
            return bArr;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            return a(bArr, MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(b(bArr2).getEncoded(), a);
        Cipher instance = Cipher.getInstance(a);
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static java.lang.String b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ Exception -> 0x0015 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x0015 }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x0015 }
        r2 = r2.getBytes(r1);	 Catch:{ Exception -> 0x0015 }
        r2 = r0.digest(r2);	 Catch:{ Exception -> 0x0015 }
        r2 = c(r2);	 Catch:{ Exception -> 0x0015 }
        return r2;
    L_0x0015:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.analytics.c.a.b(java.lang.String):java.lang.String");
    }

    private static Key b(byte[] bArr) {
        return new SecretKeySpec(bArr, a);
    }

    private static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte a : bArr) {
            stringBuffer.append(a(a));
        }
        return stringBuffer.toString();
    }
}
