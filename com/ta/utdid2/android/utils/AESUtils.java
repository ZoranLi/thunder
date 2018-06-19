package com.ta.utdid2.android.utils;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
    public static final String TAG = "AESUtils";
    public static byte[] t = new byte[]{(byte) 48, (byte) 48, (byte) 49, (byte) 55, (byte) 68, (byte) 67, (byte) 49, (byte) 66, (byte) 69, (byte) 50, (byte) 50, (byte) 53, (byte) 56, (byte) 53, (byte) 53, (byte) 52, (byte) 67, (byte) 70, (byte) 48, (byte) 50, (byte) 67, (byte) 53, (byte) 55, (byte) 66, (byte) 55, (byte) 56, (byte) 69, (byte) 55, (byte) 52, (byte) 48, (byte) 65, (byte) 53};

    public static java.lang.String encrypt(java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x0012 }
        r1 = getRawKey(r1);	 Catch:{ Exception -> 0x0012 }
        r2 = r2.getBytes();	 Catch:{ Exception -> 0x0012 }
        r1 = encrypt(r1, r2);	 Catch:{ Exception -> 0x0012 }
        goto L_0x0013;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        if (r1 == 0) goto L_0x001a;
    L_0x0015:
        r1 = toHex(r1);
        return r1;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.AESUtils.encrypt(java.lang.String, java.lang.String):java.lang.String");
    }

    public static java.lang.String decrypt(java.lang.String r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0016 }
        r0 = getRawKey(r0);	 Catch:{ Exception -> 0x0016 }
        r1 = toByte(r1);	 Catch:{ Exception -> 0x0016 }
        r0 = decrypt(r0, r1);	 Catch:{ Exception -> 0x0016 }
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x0016 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0016 }
        return r1;
    L_0x0016:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.AESUtils.decrypt(java.lang.String, java.lang.String):java.lang.String");
    }

    private static byte[] getRawKey(byte[] bArr) throws Exception {
        return toByte(new String(t, 0, 32));
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        bArr = Cipher.getInstance("AES/CBC/PKCS5Padding");
        bArr.init(1, secretKeySpec, new IvParameterSpec(new byte[bArr.getBlockSize()]));
        return bArr.doFinal(bArr2);
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) throws Exception {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        bArr = Cipher.getInstance("AES/CBC/PKCS5Padding");
        bArr.init(2, secretKeySpec, new IvParameterSpec(new byte[bArr.getBlockSize()]));
        return bArr.doFinal(bArr2);
    }

    public static String toHex(String str) {
        return toHex(str.getBytes());
    }

    public static String fromHex(String str) {
        return new String(toByte(str));
    }

    public static byte[] toByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = 2 * i;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(2 * bArr.length);
        for (byte appendHex : bArr) {
            appendHex(stringBuffer, appendHex);
        }
        return stringBuffer.toString();
    }

    private static void appendHex(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
    }
}
