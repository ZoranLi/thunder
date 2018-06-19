package org.android.agoo.common;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
public final class b {
    private static byte[] a = new byte[]{(byte) 82, (byte) 22, (byte) 50, (byte) 44, (byte) -16, (byte) 124, (byte) -40, (byte) -114, (byte) -87, (byte) -40, (byte) 37, (byte) 23, (byte) -56, (byte) 23, (byte) -33, (byte) 75};
    private static ThreadLocal<Cipher> b = new ThreadLocal();
    private static final AlgorithmParameterSpec c = new IvParameterSpec(a);

    public static final byte[] a(byte[] bArr, SecretKeySpec secretKeySpec, byte[] bArr2) throws IllegalArgumentException {
        try {
            return a(secretKeySpec, bArr2, 2).doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr2 = new StringBuilder("AES decrypt error:");
            bArr2.append(bArr3.getMessage());
            throw new IllegalArgumentException(bArr2.toString(), bArr3);
        } catch (byte[] bArr32) {
            bArr2 = new StringBuilder("AES decrypt error:");
            bArr2.append(bArr32.getMessage());
            throw new IllegalArgumentException(bArr2.toString(), bArr32);
        }
    }

    private static final Cipher a(SecretKeySpec secretKeySpec, byte[] bArr, int i) {
        Cipher a = a();
        try {
            a.init(i, secretKeySpec, new IvParameterSpec(bArr));
            return a;
        } catch (SecretKeySpec secretKeySpec2) {
            i = new StringBuilder("init Chipher error:");
            i.append(secretKeySpec2.getMessage());
            throw new RuntimeException(i.toString(), secretKeySpec2);
        } catch (SecretKeySpec secretKeySpec22) {
            i = new StringBuilder("init Chipher error:");
            i.append(secretKeySpec22.getMessage());
            throw new RuntimeException(i.toString(), secretKeySpec22);
        } catch (SecretKeySpec secretKeySpec222) {
            i = new StringBuilder("init Chipher error:");
            i.append(secretKeySpec222.getMessage());
            throw new RuntimeException(i.toString(), secretKeySpec222);
        }
    }

    private static final Cipher a() {
        StringBuilder stringBuilder;
        Cipher cipher = (Cipher) b.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                b.set(cipher);
            } catch (Throwable e) {
                stringBuilder = new StringBuilder("get Chipher error:");
                stringBuilder.append(e.getMessage());
                throw new RuntimeException(stringBuilder.toString(), e);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder("get Chipher error:");
                stringBuilder.append(e2.getMessage());
                throw new RuntimeException(stringBuilder.toString(), e2);
            }
        }
        return cipher;
    }

    public static final byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (byte[] bArr2) {
            RuntimeException runtimeException = new RuntimeException("md5 value Throwable", bArr2);
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
        try {
            bArr = Mac.getInstance("HmacSHA1");
            bArr.init(secretKeySpec);
            return bArr.doFinal(bArr2);
        } catch (byte[] bArr3) {
            bArr2 = new RuntimeException("HmacSHA1 Throwable", bArr3);
        }
    }

    public static byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
