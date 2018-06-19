package com.xunlei.common.encrypt;

import com.baidu.android.common.security.RSAUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class RSATools {
    private static String RSA = "RSA";
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static KeyPair generateRSAKeyPair() {
        return generateRSAKeyPair(1024);
    }

    public static KeyPair generateRSAKeyPair(int i) {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(RSA);
            instance.initialize(i);
            return instance.genKeyPair();
        } catch (int i2) {
            i2.printStackTrace();
            return 0;
        }
    }

    public static PublicKey getPublicKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static PrivateKey getPrivateKey(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static PublicKey getPublicKey(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePublic(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static PrivateKey getPrivateKey(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(RSA).generatePrivate(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static java.security.PublicKey loadPublicKey(java.lang.String r2) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = com.xunlei.common.encrypt.Base64.decode(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r0 = RSA;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r0 = java.security.KeyFactory.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r1 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r1.<init>(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r2 = r0.generatePublic(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r2 = (java.security.interfaces.RSAPublicKey) r2;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        return r2;
    L_0x0016:
        r2 = new java.lang.Exception;
        r0 = "公钥数据为空";
        r2.<init>(r0);
        throw r2;
    L_0x001e:
        r2 = new java.lang.Exception;
        r0 = "公钥非法";
        r2.<init>(r0);
        throw r2;
    L_0x0026:
        r2 = new java.lang.Exception;
        r0 = "无此算法";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.RSATools.loadPublicKey(java.lang.String):java.security.PublicKey");
    }

    public static java.security.PrivateKey loadPrivateKey(java.lang.String r1) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = com.xunlei.common.encrypt.Base64.decode(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r0 = new java.security.spec.PKCS8EncodedKeySpec;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r0.<init>(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r1 = RSA;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r1 = java.security.KeyFactory.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r1 = r1.generatePrivate(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r1 = (java.security.interfaces.RSAPrivateKey) r1;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        return r1;
    L_0x0016:
        r1 = new java.lang.Exception;
        r0 = "私钥数据为空";
        r1.<init>(r0);
        throw r1;
    L_0x001e:
        r1 = new java.lang.Exception;
        r0 = "私钥非法";
        r1.<init>(r0);
        throw r1;
    L_0x0026:
        r1 = new java.lang.Exception;
        r0 = "无此算法";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.RSATools.loadPrivateKey(java.lang.String):java.security.PrivateKey");
    }

    public static java.security.PublicKey loadPublicKey(java.io.InputStream r1) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = readKey(r1);	 Catch:{ IOException -> 0x0011, NullPointerException -> 0x0009 }
        r1 = loadPublicKey(r1);	 Catch:{ IOException -> 0x0011, NullPointerException -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = new java.lang.Exception;
        r0 = "公钥输入流为空";
        r1.<init>(r0);
        throw r1;
    L_0x0011:
        r1 = new java.lang.Exception;
        r0 = "公钥数据流读取错误";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.RSATools.loadPublicKey(java.io.InputStream):java.security.PublicKey");
    }

    public static java.security.PrivateKey loadPrivateKey(java.io.InputStream r1) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = readKey(r1);	 Catch:{ IOException -> 0x0011, NullPointerException -> 0x0009 }
        r1 = loadPrivateKey(r1);	 Catch:{ IOException -> 0x0011, NullPointerException -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = new java.lang.Exception;
        r0 = "私钥输入流为空";
        r1.<init>(r0);
        throw r1;
    L_0x0011:
        r1 = new java.lang.Exception;
        r0 = "私钥数据读取错误";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.RSATools.loadPrivateKey(java.io.InputStream):java.security.PrivateKey");
    }

    private static String readKey(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        inputStream = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return inputStream.toString();
            }
            if (readLine.charAt(0) != '-') {
                inputStream.append(readLine);
                inputStream.append('\r');
            }
        }
    }

    public static byte[] encryptData(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance(RSA);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    public static byte[] decryptData(byte[] r2, java.security.PrivateKey r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = RSA;	 Catch:{ Exception -> 0x000f }
        r0 = javax.crypto.Cipher.getInstance(r0);	 Catch:{ Exception -> 0x000f }
        r1 = 2;	 Catch:{ Exception -> 0x000f }
        r0.init(r1, r3);	 Catch:{ Exception -> 0x000f }
        r2 = r0.doFinal(r2);	 Catch:{ Exception -> 0x000f }
        return r2;
    L_0x000f:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.encrypt.RSATools.decryptData(byte[], java.security.PrivateKey):byte[]");
    }

    public static String sign(String str, String str2, String str3) {
        try {
            str2 = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2)));
            Signature instance = Signature.getInstance(SIGN_ALGORITHMS);
            instance.initSign(str2);
            instance.update(str.getBytes(str3));
            return Base64.encode(instance.sign());
        } catch (String str4) {
            str4.printStackTrace();
            return null;
        }
    }

    public static String sign(String str, PrivateKey privateKey, String str2) {
        try {
            Signature instance = Signature.getInstance(SIGN_ALGORITHMS);
            instance.initSign(privateKey);
            instance.update(str.getBytes(str2));
            return Base64.encode(instance.sign());
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        }
    }

    public static boolean verify(String str, String str2, String str3, String str4) {
        try {
            str3 = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str3)));
            Signature instance = Signature.getInstance(SIGN_ALGORITHMS);
            instance.initVerify(str3);
            instance.update(str.getBytes(str4));
            return instance.verify(Base64.decode(str2));
        } catch (String str5) {
            str5.printStackTrace();
            return null;
        }
    }

    public static boolean verify(String str, String str2, PublicKey publicKey, String str3) {
        try {
            Signature instance = Signature.getInstance(SIGN_ALGORITHMS);
            instance.initVerify(publicKey);
            instance.update(str.getBytes(str3));
            return instance.verify(Base64.decode(str2));
        } catch (String str4) {
            str4.printStackTrace();
            return null;
        }
    }

    public static void printPublicKeyInfo(PublicKey publicKey) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
        System.out.println("----------RSAPublicKey----------");
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder("Modulus.length=");
        stringBuilder.append(rSAPublicKey.getModulus().bitLength());
        printStream.println(stringBuilder.toString());
        printStream = System.out;
        stringBuilder = new StringBuilder("Modulus=");
        stringBuilder.append(rSAPublicKey.getModulus().toString());
        printStream.println(stringBuilder.toString());
        printStream = System.out;
        stringBuilder = new StringBuilder("PublicExponent.length=");
        stringBuilder.append(rSAPublicKey.getPublicExponent().bitLength());
        printStream.println(stringBuilder.toString());
        printStream = System.out;
        stringBuilder = new StringBuilder("PublicExponent=");
        stringBuilder.append(rSAPublicKey.getPublicExponent().toString());
        printStream.println(stringBuilder.toString());
    }

    public static void printPrivateKeyInfo(PrivateKey privateKey) {
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) privateKey;
        System.out.println("----------RSAPrivateKey ----------");
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder("Modulus.length=");
        stringBuilder.append(rSAPrivateKey.getModulus().bitLength());
        printStream.println(stringBuilder.toString());
        printStream = System.out;
        stringBuilder = new StringBuilder("Modulus=");
        stringBuilder.append(rSAPrivateKey.getModulus().toString());
        printStream.println(stringBuilder.toString());
        printStream = System.out;
        stringBuilder = new StringBuilder("PrivateExponent.length=");
        stringBuilder.append(rSAPrivateKey.getPrivateExponent().bitLength());
        printStream.println(stringBuilder.toString());
        printStream = System.out;
        stringBuilder = new StringBuilder("PrivatecExponent=");
        stringBuilder.append(rSAPrivateKey.getPrivateExponent().toString());
        printStream.println(stringBuilder.toString());
    }
}
