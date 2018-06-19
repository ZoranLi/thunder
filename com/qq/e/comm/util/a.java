package com.qq.e.comm.util;

import android.util.Base64;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class a {
    private PublicKey a;
    private final boolean b;

    static final class a {
        public static final a a = new a();
    }

    private a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>();
        r0 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB";	 Catch:{ Throwable -> 0x000d }
        r0 = b(r0);	 Catch:{ Throwable -> 0x000d }
        r1.a = r0;	 Catch:{ Throwable -> 0x000d }
        r0 = 1;
        goto L_0x000e;
    L_0x000d:
        r0 = 0;
    L_0x000e:
        r1.b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.a.<init>():void");
    }

    public static a a() {
        return a.a;
    }

    private String a(String str) {
        if (this.a != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                instance.init(2, this.a);
                return new String(instance.doFinal(decode), "UTF-8").trim();
            } catch (Throwable th) {
                GDTLogger.e("ErrorWhileVerifySigNature", th);
            }
        }
        return null;
    }

    private static java.security.PublicKey b(java.lang.String r2) throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = android.util.Base64.decode(r2, r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r0 = "RSA";	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r0 = java.security.KeyFactory.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r1 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r1.<init>(r2);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        r2 = r0.generatePublic(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0025, InvalidKeySpecException -> 0x001d, NullPointerException -> 0x0015 }
        return r2;
    L_0x0015:
        r2 = new java.lang.Exception;
        r0 = "公钥数据为空";
        r2.<init>(r0);
        throw r2;
    L_0x001d:
        r2 = new java.lang.Exception;
        r0 = "公钥非法";
        r2.<init>(r0);
        throw r2;
    L_0x0025:
        r2 = new java.lang.Exception;
        r0 = "无此算法";
        r2.<init>(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.a.b(java.lang.String):java.security.PublicKey");
    }

    public final boolean a(String str, String str2) {
        return b(str, Md5Util.encode(str2));
    }

    public final boolean b(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (!this.b) {
            return true;
        }
        str = a(str);
        boolean equals = str2.equals(str);
        StringBuilder stringBuilder = new StringBuilder("Verify Result");
        stringBuilder.append(equals);
        stringBuilder.append("src=");
        stringBuilder.append(str2);
        stringBuilder.append(" & target=");
        stringBuilder.append(str);
        GDTLogger.d(stringBuilder.toString());
        return equals;
    }
}
