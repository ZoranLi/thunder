package com.xunlei.common.encrypt;

import java.io.PrintStream;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
            bArr2 = Cipher.getInstance("AES/ECB/NoPadding");
            bArr2.init(1, secretKeySpec);
            return bArr2.doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr3.printStackTrace();
            return null;
        } catch (byte[] bArr32) {
            bArr32.printStackTrace();
            return null;
        } catch (byte[] bArr322) {
            bArr322.printStackTrace();
            return null;
        } catch (byte[] bArr3222) {
            bArr3222.printStackTrace();
            return null;
        } catch (byte[] bArr32222) {
            bArr32222.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        try {
            String str = "AES";
            if (z2) {
                z2 = new StringBuilder();
                z2.append(str);
                z2.append("/ECB");
                str = z2.toString();
            }
            if (z) {
                z = new StringBuilder();
                z.append(str);
                z.append("/NoPadding");
                str = z.toString();
            }
            z = new SecretKeySpec(bArr2, "AES");
            bArr2 = Cipher.getInstance(str);
            bArr2.init(true, z);
            return bArr2.doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr3.printStackTrace();
            return null;
        } catch (byte[] bArr32) {
            bArr32.printStackTrace();
            return null;
        } catch (byte[] bArr322) {
            bArr322.printStackTrace();
            return null;
        } catch (byte[] bArr3222) {
            bArr3222.printStackTrace();
            return null;
        } catch (byte[] bArr32222) {
            bArr32222.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
            StringBuilder stringBuilder = new StringBuilder("AES/");
            stringBuilder.append(str2);
            stringBuilder.append("/");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            str2 = new IvParameterSpec(bArr2);
            bArr2 = Cipher.getInstance(str);
            bArr2.init(1, secretKeySpec, str2);
            return bArr2.doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr3.printStackTrace();
            return null;
        } catch (byte[] bArr32) {
            bArr32.printStackTrace();
            return null;
        } catch (byte[] bArr322) {
            bArr322.printStackTrace();
            return null;
        } catch (byte[] bArr3222) {
            bArr3222.printStackTrace();
            return null;
        } catch (byte[] bArr32222) {
            bArr32222.printStackTrace();
            return null;
        } catch (byte[] bArr322222) {
            bArr322222.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, String str, String str2) {
        try {
            StringBuilder stringBuilder = new StringBuilder("AES/");
            stringBuilder.append(str2);
            stringBuilder.append("/");
            stringBuilder.append(str);
            str = stringBuilder.toString();
            str2 = new SecretKeySpec(bArr2, "AES");
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            bArr2 = Cipher.getInstance(str);
            bArr2.init(2, str2, ivParameterSpec);
            return bArr2.doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr3.printStackTrace();
            return null;
        } catch (byte[] bArr32) {
            bArr32.printStackTrace();
            return null;
        } catch (byte[] bArr322) {
            bArr322.printStackTrace();
            return null;
        } catch (byte[] bArr3222) {
            bArr3222.printStackTrace();
            return null;
        } catch (byte[] bArr32222) {
            bArr32222.printStackTrace();
            return null;
        } catch (byte[] bArr322222) {
            bArr322222.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
            bArr2 = Cipher.getInstance("AES/ECB/NoPadding");
            bArr2.init(2, secretKeySpec);
            return bArr2.doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr3.printStackTrace();
            return null;
        } catch (byte[] bArr32) {
            bArr32.printStackTrace();
            return null;
        } catch (byte[] bArr322) {
            bArr322.printStackTrace();
            return null;
        } catch (byte[] bArr3222) {
            bArr3222.printStackTrace();
            return null;
        } catch (byte[] bArr32222) {
            bArr32222.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        try {
            String str = "AES";
            if (z2) {
                z2 = new StringBuilder();
                z2.append(str);
                z2.append("/ECB");
                str = z2.toString();
            }
            if (z) {
                z = new StringBuilder();
                z.append(str);
                z.append("/NoPadding");
                str = z.toString();
            }
            z = new SecretKeySpec(bArr2, "AES");
            bArr2 = Cipher.getInstance(str);
            bArr2.init(true, z);
            return bArr2.doFinal(bArr);
        } catch (byte[] bArr3) {
            bArr3.printStackTrace();
            return null;
        } catch (byte[] bArr32) {
            bArr32.printStackTrace();
            return null;
        } catch (byte[] bArr322) {
            bArr322.printStackTrace();
            return null;
        } catch (byte[] bArr3222) {
            bArr3222.printStackTrace();
            return null;
        } catch (byte[] bArr32222) {
            bArr32222.printStackTrace();
            return null;
        }
    }

    public static byte[] getRawKey(int i, byte[] bArr) throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG");
        instance2.setSeed(bArr);
        instance.init(i, instance2);
        return instance.generateKey().getEncoded();
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            str2 = deriveKeyInsecurely(str2, 128);
            Cipher instance = Cipher.getInstance("AES");
            str = str.getBytes("UTF-8");
            instance.init(1, str2);
            return instance.doFinal(str);
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        } catch (String str32) {
            str32.printStackTrace();
            return null;
        } catch (String str322) {
            str322.printStackTrace();
            return null;
        } catch (String str3222) {
            str3222.printStackTrace();
            return null;
        } catch (String str32222) {
            str32222.printStackTrace();
            return null;
        } catch (String str322222) {
            str322222.printStackTrace();
            return null;
        }
    }

    public static byte[] decrypt(byte[] bArr, String str) {
        try {
            str = deriveKeyInsecurely(str, 128);
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, str);
            return instance.doFinal(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        } catch (byte[] bArr22) {
            bArr22.printStackTrace();
            return null;
        } catch (byte[] bArr222) {
            bArr222.printStackTrace();
            return null;
        } catch (byte[] bArr2222) {
            bArr2222.printStackTrace();
            return null;
        } catch (byte[] bArr22222) {
            bArr22222.printStackTrace();
            return null;
        }
    }

    private static SecretKey deriveKeyInsecurely(String str, int i) {
        try {
            return new SecretKeySpec(InsecureSHA1PRNGKeyDerivator.deriveInsecureKey(str.getBytes("UTF-8"), i / 8), "AES");
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static void main(String[] strArr) {
        strArr = "test";
        String str = "12345678";
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder("加密前：");
        stringBuilder.append(strArr);
        printStream.println(stringBuilder.toString());
        strArr = decrypt(encrypt(strArr.getBytes(), str.getBytes()), str.getBytes());
        PrintStream printStream2 = System.out;
        StringBuilder stringBuilder2 = new StringBuilder("解密后：");
        stringBuilder2.append(new String(strArr));
        printStream2.println(stringBuilder2.toString());
    }
}
