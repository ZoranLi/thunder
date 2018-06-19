package com.xunlei.downloadprovider.thirdpart.content;

import java.security.PublicKey;
import javax.crypto.Cipher;

/* compiled from: RSAUtils */
public final class a {
    private static String a = "RSA";

    public static byte[] a(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher instance = Cipher.getInstance(a);
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    private static java.security.PublicKey a(java.lang.String r2) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = com.xunlei.xllib.b.b.a(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
        r0 = a;	 Catch:{ NoSuchAlgorithmException -> 0x0026, InvalidKeySpecException -> 0x001e, NullPointerException -> 0x0016 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.thirdpart.content.a.a(java.lang.String):java.security.PublicKey");
    }

    public static java.security.PublicKey a(java.io.InputStream r4) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r1.<init>(r4);	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r4.<init>();	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
    L_0x000f:
        r1 = r0.readLine();	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        if (r1 == 0) goto L_0x0027;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
    L_0x0015:
        r2 = 0;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r2 = r1.charAt(r2);	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r3 = 45;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        if (r2 == r3) goto L_0x000f;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
    L_0x001e:
        r4.append(r1);	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r1 = 13;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r4.append(r1);	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        goto L_0x000f;	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
    L_0x0027:
        r4 = r4.toString();	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        r4 = a(r4);	 Catch:{ IOException -> 0x0038, NullPointerException -> 0x0030 }
        return r4;
    L_0x0030:
        r4 = new java.lang.Exception;
        r0 = "公钥输入流为空";
        r4.<init>(r0);
        throw r4;
    L_0x0038:
        r4 = new java.lang.Exception;
        r0 = "公钥数据流读取错误";
        r4.<init>(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.thirdpart.content.a.a(java.io.InputStream):java.security.PublicKey");
    }
}
