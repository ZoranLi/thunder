package com.xunlei.common.encrypt;

import java.security.MessageDigest;

public class MD5 {
    public static byte[] encrypt(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr, 0, bArr.length);
            return instance.digest();
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    public static String encrypt(String str) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        str = encrypt(str.getBytes());
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(32);
        for (byte b : str) {
            stringBuilder.append(cArr[(b >> 4) & 15]);
            stringBuilder.append(cArr[b & 15]);
        }
        return stringBuilder.toString();
    }

    public static final java.lang.String getMessageDigest(byte[] r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 16;
        r0 = new char[r0];
        r0 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        r1 = "MD5";	 Catch:{ Exception -> 0x003b }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003b }
        r1.update(r9);	 Catch:{ Exception -> 0x003b }
        r9 = r1.digest();	 Catch:{ Exception -> 0x003b }
        r1 = r9.length;	 Catch:{ Exception -> 0x003b }
        r2 = r1 << 1;	 Catch:{ Exception -> 0x003b }
        r2 = new char[r2];	 Catch:{ Exception -> 0x003b }
        r3 = 0;	 Catch:{ Exception -> 0x003b }
        r4 = r3;	 Catch:{ Exception -> 0x003b }
    L_0x001b:
        if (r3 < r1) goto L_0x0023;	 Catch:{ Exception -> 0x003b }
    L_0x001d:
        r9 = new java.lang.String;	 Catch:{ Exception -> 0x003b }
        r9.<init>(r2);	 Catch:{ Exception -> 0x003b }
        return r9;	 Catch:{ Exception -> 0x003b }
    L_0x0023:
        r5 = r9[r3];	 Catch:{ Exception -> 0x003b }
        r6 = r4 + 1;	 Catch:{ Exception -> 0x003b }
        r7 = r5 >>> 4;	 Catch:{ Exception -> 0x003b }
        r8 = 15;	 Catch:{ Exception -> 0x003b }
        r7 = r7 & r8;	 Catch:{ Exception -> 0x003b }
        r7 = r0[r7];	 Catch:{ Exception -> 0x003b }
        r2[r4] = r7;	 Catch:{ Exception -> 0x003b }
        r4 = r6 + 1;	 Catch:{ Exception -> 0x003b }
        r5 = r5 & 15;	 Catch:{ Exception -> 0x003b }
        r5 = r0[r5];	 Catch:{ Exception -> 0x003b }
        r2[r6] = r5;	 Catch:{ Exception -> 0x003b }
        r3 = r3 + 1;
        goto L_0x001b;
    L_0x003b:
        r9 = 0;
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.MD5.getMessageDigest(byte[]):java.lang.String");
    }

    public static final byte[] getRawDigest(byte[] r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "MD5";	 Catch:{ Exception -> 0x000e }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x000e }
        r0.update(r1);	 Catch:{ Exception -> 0x000e }
        r1 = r0.digest();	 Catch:{ Exception -> 0x000e }
        return r1;
    L_0x000e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.MD5.getRawDigest(byte[]):byte[]");
    }
}
