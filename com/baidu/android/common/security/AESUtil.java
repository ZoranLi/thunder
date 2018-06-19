package com.baidu.android.common.security;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AESUtil {
    private static final String ALGORITHM_NAME = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private AESUtil() {
    }

    public static byte[] decrypt(String str, String str2, byte[] bArr) throws Exception {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), ALGORITHM_NAME);
        Cipher instance = Cipher.getInstance(TRANSFORMATION);
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    public static byte[] encrypt(String str, String str2, byte[] bArr) throws Exception {
        Key secretKeySpec = new SecretKeySpec(str2.getBytes(), ALGORITHM_NAME);
        Cipher instance = Cipher.getInstance(TRANSFORMATION);
        instance.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }
}
