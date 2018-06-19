package com.xiaomi.channel.commonutils.string;

import java.util.Collection;
import java.util.Random;

public class d {
    public static String a(int i) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static java.lang.String a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 == 0) goto L_0x0026;
    L_0x0002:
        r0 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = c(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0.update(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = new java.math.BigInteger;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1.<init>(r2, r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = "%1$032X";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2[r3] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.lang.String.format(r0, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        return r0;
    L_0x0025:
        return r4;
    L_0x0026:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.string.d.a(java.lang.String):java.lang.String");
    }

    public static String a(Collection<?> collection, String str) {
        return collection == null ? null : a(collection.iterator(), str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.util.Iterator<?> r3, java.lang.String r4) {
        /*
        if (r3 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
        return r3;
    L_0x0004:
        r0 = r3.hasNext();
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r3 = "";
        return r3;
    L_0x000d:
        r0 = r3.next();
        r1 = r3.hasNext();
        if (r1 != 0) goto L_0x001c;
    L_0x0017:
        r3 = r0.toString();
        return r3;
    L_0x001c:
        r1 = new java.lang.StringBuffer;
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r1.<init>(r2);
        if (r0 == 0) goto L_0x0028;
    L_0x0025:
        r1.append(r0);
    L_0x0028:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x003a;
    L_0x002e:
        if (r4 == 0) goto L_0x0033;
    L_0x0030:
        r1.append(r4);
    L_0x0033:
        r0 = r3.next();
        if (r0 == 0) goto L_0x0028;
    L_0x0039:
        goto L_0x0025;
    L_0x003a:
        r3 = r1.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.string.d.a(java.util.Iterator, java.lang.String):java.lang.String");
    }

    public static String a(Object[] objArr, String str) {
        return objArr == null ? null : a(objArr, str, 0, objArr.length);
    }

    public static String a(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(i3 * ((objArr[i] == null ? 16 : objArr[i].toString().length()) + str.length()));
        for (i3 = i; i3 < i2; i3++) {
            if (i3 > i) {
                stringBuffer.append(str);
            }
            if (objArr[i3] != null) {
                stringBuffer.append(objArr[i3]);
            }
        }
        return stringBuffer.toString();
    }

    public static java.lang.String b(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 == 0) goto L_0x0026;
    L_0x0002:
        r0 = "SHA1";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = c(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0.update(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = new java.math.BigInteger;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = r0.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = 1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1.<init>(r2, r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = "%1$032X";	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r3 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r2[r3] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r0 = java.lang.String.format(r0, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        return r0;
    L_0x0025:
        return r4;
    L_0x0026:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.string.d.b(java.lang.String):java.lang.String");
    }

    public static byte[] c(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        r0 = r1.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        return r0;
    L_0x0007:
        r1 = r1.getBytes();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.string.d.c(java.lang.String):byte[]");
    }

    public static boolean d(String str) {
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt < '\u0000' || charAt > '') {
                    return false;
                }
            }
        }
        return true;
    }
}
