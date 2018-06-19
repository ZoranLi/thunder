package com.baidu.android.common.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public final class RSAUtil {
    public static final String ALGORITHM_RSA = "RSA";
    public static final int BYTE_IN_BITS = 8;
    public static final String PRIVATE_KEY = "PrivateKey";
    public static final int PT_MAXLEN_OFFSET = 11;
    public static final String PUBLIC_KEY = "PublicKey";

    private RSAUtil() {
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        Key generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePrivate);
        return instance.doFinal(bArr);
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) throws Exception {
        Key generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePublic);
        return instance.doFinal(bArr);
    }

    public static byte[] decryptLongByPrivateKey(byte[] bArr, String str, int i) throws Exception {
        Key generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePrivate);
        i /= 8;
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = length - i2;
            if (i < i3) {
                i3 = i;
            }
            Object obj = new byte[i3];
            System.arraycopy(bArr, i2, obj, 0, i3);
            i2 += i3;
            stringBuilder.append(new String(instance.doFinal(obj)));
        }
        return stringBuilder.toString().getBytes();
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, String str) throws Exception {
        Key generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePrivate);
        return instance.doFinal(bArr);
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        Key generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        return instance.doFinal(bArr);
    }

    public static byte[] encryptLongByPublicKey(byte[] bArr, String str, int i) throws Exception {
        Key generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePublic);
        i /= 8;
        int i2 = i - 11;
        int length = bArr.length;
        Object obj = new byte[((((length + i2) - 1) / i2) * i)];
        int i3 = 0;
        int i4 = i3;
        while (i3 < length) {
            int i5 = length - i3;
            if (i2 < i5) {
                i5 = i2;
            }
            Object obj2 = new byte[i5];
            System.arraycopy(bArr, i3, obj2, 0, i5);
            i3 += i5;
            System.arraycopy(instance.doFinal(obj2), 0, obj, i4, i);
            i4 += i;
        }
        return obj;
    }

    public static Map<String, Object> generateKey(int i) throws NoSuchAlgorithmException {
        KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        instance.initialize(i);
        KeyPair generateKeyPair = instance.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) generateKeyPair.getPublic();
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) generateKeyPair.getPrivate();
        Map<String, Object> hashMap = new HashMap(2);
        hashMap.put(PUBLIC_KEY, rSAPublicKey);
        hashMap.put(PRIVATE_KEY, rSAPrivateKey);
        return hashMap;
    }

    public static RSAPrivateKey generateRSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        try {
            try {
                return (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
            } catch (InvalidKeySpecException e) {
                throw new Exception(e.getMessage());
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception(e2.getMessage());
        }
    }

    public static RSAPublicKey generateRSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
            } catch (InvalidKeySpecException e) {
                throw new Exception(e.getMessage());
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new Exception(e2.getMessage());
        }
    }

    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        return Base64.encode(((Key) map.get(PRIVATE_KEY)).getEncoded(), "utf-8");
    }

    public static String getPublicKey(Map<String, Object> map) throws UnsupportedEncodingException {
        return Base64.encode(((Key) map.get(PUBLIC_KEY)).getEncoded(), "utf-8");
    }
}
